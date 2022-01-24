package com.example.study.test

import kotlin.coroutines.*

/**
 *@author ZhiQiang Tu
 *@time 2022/1/18  17:02
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {
    val continuation = suspend {
        //com.example.study.delay(1000)
        Unit
    }.createCoroutine(object : Continuation<Unit> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Unit>) {
            println("lambda1 恢复执行")
        }
    })
   // suspendCoroutine<> {  }


    println("aa")
    Thread.sleep(1000)
    continuation.resume(Unit)
}