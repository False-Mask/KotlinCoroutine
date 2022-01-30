package com.example.framework.channel.iterator

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/30  10:03
 *@signature 我将追寻并获取我想要的答案
 */

fun main(): Unit = runBlocking {
    val channel = Channel<Int>()
    launch {
        for (x in 1..10) {
            channel.send(x)
        }
        channel.close()
    }

    for (element in channel) {
        println(element)
    }
    println("Done")
}

