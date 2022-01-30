package com.example.framework.channel.primary

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/29  19:29
 *@signature 我将追寻并获取我想要的答案
 */

fun main(): Unit = runBlocking {
    val channel = Channel<Int>()
    launch {
        for (x in 1..10){
            channel.send(x)
        }
    }

    repeat(10){
        println(channel.receive())
    }
    println("Done")
}






