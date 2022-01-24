package com.example.base

import kotlinx.coroutines.delay
import kotlinx.coroutines.intrinsics.startCoroutineCancellable
import kotlin.coroutines.*

/**
 *@author ZhiQiang Tu
 *@time 2022/1/24  15:18
 *@signature 我将追寻并获取我想要的答案
 */
class LogInterceptor : ContinuationInterceptor {

    override val key: CoroutineContext.Key<*>
        get() = ContinuationInterceptor

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return LogContinuation(continuation)
    }
}

class LogContinuation<T>(private val continuation: Continuation<T>) : Continuation<T> by continuation {
    override fun resumeWith(result: Result<T>) {
        println("resume前面")
        continuation.resumeWith(result)
        println("resume后")
    }
}

fun main() {
    suspend {

        delay(1000)
        delay(2000)
        delay(3000)

    }.startCoroutine(object : Continuation<Unit> {
            override val context: CoroutineContext
                get() = LogInterceptor()

            override fun resumeWith(result: Result<Unit>) {
                println("finished")
            }

        })

    Thread.sleep(100000)

}
