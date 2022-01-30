package com.example.framework.channel.bufer

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/30  10:20
 *@signature 我将追寻并获取我想要的答案
 */

fun main(): Unit = runBlocking {
    val channel = Channel<Int>(10)
    repeat(11) {
        channel.send(it)
    }
    channel.close()
    println("send finish")
    for (i in channel) {
        println(i)
    }
}

