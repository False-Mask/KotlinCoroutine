package com.example.study.yield

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

/**
 *@author ZhiQiang Tu
 *@time 2022/1/19  12:11
 *@signature 我将追寻并获取我想要的答案
 */
fun main(): Unit = runBlocking {
    launch {
        while (true) {
            //假如做了cpu密集任务
            println("A")
            delay(1000)
            yield()
        }
    }

    launch {
        while (true) {
            println("B")
            delay(1000000)
            yield()
        }
    }
}