package com.example.study.coroutinebuilder.async

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/20  10:44
 *@signature 我将追寻并获取我想要的答案
 */
fun main() = runBlocking {
    val defferJob = async {
        delay(1000)
        "假装有返回值"
    }
    val result = defferJob.await()
    println(result+Thread.currentThread().name)
}