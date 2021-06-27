package com.example.usecoroutine.unit3_6_27

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlin.concurrent.thread
import kotlin.coroutines.*

/**
 *@author ZhiQiang Tu
 *@time 2021/6/27  10:14
 *我将追寻并获取我想要的答案
 */
class Main_6_27 {
}

//3.2.1
//主要是代码分析，没有实例。
//@Test
private suspend fun suspendTest():Int = suspendCoroutine<Int> {
    EmptyCoroutineContext
}

//3.3.1
//@Test
private fun createCoroutineContext(){
    val coroutineContext:CoroutineContext = CoroutineName("Baby Coroutine")+
            CoroutineExceptionHandler { coroutineContext, throwable ->
                println("怎么玩的？报错了？")
            }+
            Dispatchers.Default

    suspend {
        System.currentTimeMillis()
    }.startCoroutine(object : Continuation<Long>{
        override val context: CoroutineContext
            get() = coroutineContext

        override fun resumeWith(result: Result<Long>) {
            println("来了老弟："+result.getOrNull())
        }
    })
    Thread.sleep(1000)

}

//3.4
fun useCoroutineContext(){
    val z = System.currentTimeMillis()
    suspend {
        suspendFun01()
        suspendFun01()
    }.startCoroutine(object : Continuation<Unit>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Unit>) {
            val l = System.currentTimeMillis()
            println("挂起完毕了？"+(l-z).toString())
        }

    })
    Thread.sleep(1000)
}

suspend fun suspendFun01() = suspendCoroutine<Unit> {
    thread {
        val x = System.currentTimeMillis()
        Thread.sleep(10000)
        val y = System.currentTimeMillis()
        println("调用suspendFun01"+Thread.currentThread().name+"--time:"+(y-x).toString())
        it.resumeWith(Result.success(Unit))
    }
}


fun main(){
    suspend {
        delay(1000)
        System.currentTimeMillis()
    }.startCoroutine(object : Continuation<Long>{
        override val context: CoroutineContext
            get() = MyInterceptor()

        override fun resumeWith(result: Result<Long>) {
            println(result)
        }
    })
}