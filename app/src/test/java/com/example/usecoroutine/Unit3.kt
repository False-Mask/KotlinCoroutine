package com.example.usecoroutine

import kotlinx.coroutines.delay
import org.junit.Test
import kotlin.coroutines.*

//3.1.1
@Test
fun x(){
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
}


//3.1.3
@Test
fun main(){
    launchCoroutine(CoroutineProducer<Long>()){
        println("Coroutine begin")
        produce(System.currentTimeMillis())
        delay(1000)
        produce(System.currentTimeMillis())
    }
}

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


//3.1.4
@Test
fun main_3_1_4(){
    runSuspend{

    }
}

fun runSuspend(block: suspend () -> Unit) {
    val run = RunSuspend()
    block.startCoroutine(run)
    run.await()
}

class RunSuspend:Continuation<Unit>{
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<Unit>) {

    }

    fun await() {

    }

}

fun suspendMain(){

}


//3.2.1挂机函数
@Test
fun main_3_2_1(){

}
suspend fun suspendFunc01(){
    return
}
suspend fun suspendFun02(a:String,b:String)=
    suspendCoroutine<Long> {

    }

