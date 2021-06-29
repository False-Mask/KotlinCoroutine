# 6-29
我大抵上懂了，但好像又不是很明白...
# Kotlin Coroutine扩展实践
不懂
# Kotlin 协程框架开发初探
## delay
应该懂了
## 协程的描述
客观来见startCoroutine和createCoroutine这两个API不适合直接在业务开发中使用，对于协程的创建，在框架中也要根据不同的目的提供不同的Builder。

### 1.Job
Thread用于描述线程，为了方便描述协程，官方写了一个Job类
#### join()
类似于线程的join方法，只不过不会组设线程，执行该函数以后，协程将会被挂起。
#### cancel()
类似于Thread的interrupt方法，cancel用于取消协程
#### isActive
类似于Thread的isActive()，用于查询协程是否完成。
#### key
key用于将协程的实例存入他的上下文中。
#### invokeOnCancel
注册一个协程取消时候的回调
#### invokeOnCompletion
注册一个协程完成时候的回调
#### remove()

## 协程状态的封装
sealed class CoroutineState{
    class InComplete : CoroutineState()
    class Cancelling : CoroutineState()
    class Complete<T>(val value: T? = null,val exception: Throwable? =null) : CoroutineState()
}

# 雾
不懂

# 协程作用域
简单来说是作用域是用来管理协程的，如明确协程间的父子关系，取消协程，异常处理。
## 顶级作用域
没有父协程的协程所在的作用域为顶级作用域
## 协同作用域
协程中启动新的协程，新协程为所在协程的子协程，这种情况下子协程的作用域**默认**为协同作用域。对于子协程抛出的未捕获的异常都会传递给父协程处理，父协程同时也会被取消
## 主从作用域
不懂
## 父子协程的规则
### 父协程被取消，所有子协程均会被取消。适用于协同协程和主从协程。
### 父协程需要等待**所有子协程**完毕以后才会进入完成状态，不管父协程自身的协程体是否执行完。
### 子协程会继承父协程的上下文元素，如果自身有相同的key的成员，会覆盖对应的key，覆盖效果仅限于自身范围内有效

