package com.example.study.suspend.howtosuspend

import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 *@author ZhiQiang Tu
 *@time 2022/1/15  21:33
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
    useSuspend1()
}

suspend fun useSuspend1() = suspendCoroutine<Unit> {
    thread {
        (0..10).forEach{it1->
            Thread.sleep(1000)
            println("休眠了${it1}秒")
        }
        it.resume(Unit)
    }
}