package com.example.builder.launch

import kotlinx.coroutines.*

/**
 *@author ZhiQiang Tu
 *@time 2022/1/20  10:43
 *@signature 我将追寻并获取我想要的答案
 */
fun main(): Unit = runBlocking {
    val job = launch (start = CoroutineStart.LAZY){
        while (true){
            delay(1000)
            println("one loop finished")
        }
    }

    job.start()
}