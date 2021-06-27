package com.example.usecoroutine.unit3_6_27

import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

/**
 *@author ZhiQiang Tu
 *@time 2021/6/27  15:24
 *我将追寻并获取我想要的答案
 */
class MyInterceptor: ContinuationInterceptor{
    override val key: CoroutineContext.Key<*>
        get() = ContinuationInterceptor

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return MyContinuation(continuation)
    }
}
class MyContinuation<T>(private val continuation: Continuation<T>):Continuation<T> by continuation{
    override fun resumeWith(result: Result<T>) {
        println("before resume")
        continuation.resumeWith(result)
        println("after resume")
    }

}