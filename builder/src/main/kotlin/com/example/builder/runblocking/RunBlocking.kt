package com.example.builder.runblocking

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/18  8:56
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {
    runBlocking {
        println(Thread.currentThread().name)
        delay(100)
        println(Thread.currentThread().name)
    }
}