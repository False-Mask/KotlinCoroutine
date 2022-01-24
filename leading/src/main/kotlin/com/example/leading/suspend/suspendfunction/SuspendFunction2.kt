package com.example.study.suspend.suspendfunction

import kotlinx.coroutines.delay
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

/**
 *@author ZhiQiang Tu
 *@time 2022/1/15  19:34
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {

    var continuation = object : Continuation<Unit>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Unit>) {
            println("resumed")
        }
    }

    suspend {
        println("before com.example.study.delay")
        delay(1000)
        println("after com.example.study.delay")
        Unit
    }.startCoroutine(continuation)
    Thread.sleep(10000)

}