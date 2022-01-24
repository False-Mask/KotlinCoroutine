package com.example.study.suspend.suspendext

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.asFlow

/**
 *@author ZhiQiang Tu
 *@time 2022/1/18  17:36
 *@signature 我将追寻并获取我想要的答案
 */
@OptIn(InternalCoroutinesApi::class)
fun main() {

    //1----

    /*val safeContinuation = com.example.study.suspend {
        //println("Hello ")
    }.createCoroutine(object : Continuation<Unit>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Unit>) {
            println("resumed")
        }
    })
    safeContinuation.resume(Unit)*/


    //2----
    /*com.example.study.suspend {
        println("This is com.example.study.suspend function")
    }.startCoroutine(
        object : Continuation<Unit>{
            override fun resumeWith(result: Result<Unit>) {
                println("resumed")
            }

            override val context: CoroutineContext
                get() =     EmptyCoroutineContext

        }
    )*/


    //3----
   /* com.example.study.suspend {
        println("This is com.example.study.test com.example.study.suspend function")
        println(1/0)
        println("afasdfsdf")
    }.startCoroutineCancellable(object : Continuation<Unit>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Unit>) {
            println("resume:"+result)
        }
    })*/


    //4-----

    suspend {

    }.asFlow()

}