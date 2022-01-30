package com.example.framework.channel.source

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/30  16:32
 *@signature 我将追寻并获取我想要的答案
 */


fun main():Unit = runBlocking {
    val chan = Channel<Int>()
    launch {
        for (i in 0..9){
            chan.send(i)
            delay(100)
        }
        chan.close()
    }
    launch {
        repeat(10){
            delay(100)
            println(chan.receive())
        }
    }
}