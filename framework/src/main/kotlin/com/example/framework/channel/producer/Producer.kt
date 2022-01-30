package com.example.framework.channel.producer

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/30  10:11
 *@signature 我将追寻并获取我想要的答案
 */


fun main(): Unit = runBlocking {
    val receiveChannel = produce<Int> {
        repeat(10) { send(it) }
    }

    receiveChannel.consumeEach {
        println(it)
    }
}

