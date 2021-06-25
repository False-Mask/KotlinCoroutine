# 2021-6-25
我之所以坚持，是因为我能清晰的看见自己的成长。--TuZhiQiang
## 1.协程是什么的问题
关于协程是什么一直存在着争议，个人的想法是--没有和大佬们进行思维博弈的实力之前，可以在学习过程中慢慢了解协程是什么。
***现在我对协程的看法是：算是一种协程框架，但也不完全是。算是一种对线程池api的简化，但也不完全等价于线程池。这是一种新的,不同于线程的,对CPU资源分配的方法。再次强调关于对协程的认知需要自己慢慢形成更进修改，任何人的观点都不一定是完全准确的***
## 2.协程的创建
suspend {  }
            .createCoroutine(object : Continuation<Unit>{
            override val context: CoroutineContext
                get() = TODO("Not yet implemented")

            override fun resumeWith(result: Result<Unit>) {
                TODO("Not yet implemented")
            }
        })
通过调用一个lambda suspend{}返回一个suspend ()-> R再调用createCoroutine返回一个协程

其中suspend {}源码为
public inline fun <R> suspend(noinline block: suspend () -> R): suspend () -> R = block
我们需要传入一个挂起的 ()->R的receiver最后返回高阶函数suspend() -> R block变量通常会被我们称为协程体

其中createCoroutine源码为
public fun <T> (suspend () -> T).createCoroutine(
    completion: Continuation<T>
): Continuation<Unit> =
    SafeContinuation(createCoroutineUnintercepted(completion).intercepted(), COROUTINE_SUSPENDED)
createCoroutine (suspend () -> T)的一个扩展

其中出现了一个Continuation<T>这是用于启动协程的一个接口 Continuation是套了几层壳的协程体
@SinceKotlin("1.3")
public interface Continuation<in T> {
    /**
     * The context of the coroutine that corresponds to this continuation.
     */
    public val context: CoroutineContext

    /**
     * Resumes the execution of the corresponding coroutine passing a successful or failed [result] as the
     * return value of the last suspension point.
     */
    public fun resumeWith(result: Result<T>)
}

## 3.启动协程
再第二步的基础上再调用.resumeWith(Result.success(Unit))或者.resumeWith(Result.failure(Exception()))

## 4.代码
1.使用标准的代码 开启协程
val x =  suspend {
            System.currentTimeMillis()
        }.createCoroutine(object : Continuation<Long>{
            override val context: CoroutineContext
                get() = EmptyCoroutineContext

            override fun resumeWith(result: Result<Long>) {
                val orThrow = result.getOrThrow()
                print(orThrow)
            }

        }).resumeWith(Result.success(Unit))
            //.resumeWith(Result.failure(Exception()))
            
2.使用startCoroutine一步到位的写法
val y = suspend {
            System.currentTimeMillis()
        }.startCoroutine(object : Continuation<Long>{
            override val context: CoroutineContext
                get() = EmptyCoroutineContext

            override fun resumeWith(result: Result<Long>) {
                if (result.isFailure){
                    println("失败了呢")
                }else{
                    println(result.getOrThrow())
                }
            }
        })

3.进一步封装减少重复的创建过程
class CoroutineProducer<T>{
    suspend fun produce(value: T){
        println("I get the value :$value")
    }
}

fun <T,R>launchCoroutine(receiver:R,block:suspend R.()->T){
    block.startCoroutine(receiver,object : Continuation<T>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<T>) {
            println("Coroutine End......")
        }

    })
}

@Test
fun main(){
    launchCoroutine(CoroutineProducer<Long>()){
        println("Coroutine begin")
        produce(System.currentTimeMillis())
        delay(1000)
        produce(System.currentTimeMillis())
    }
}

#总结
协程体的创建分为3步
## 1.suspend获取协程体
## 2.将协程体包装成Continuation<T>
## 3.调用Continuation的resumeWith方法传入一个Result.success或者Result.failure(这样协程体执行内代码执行完以后便会执行Continuation内部的回调方法)
