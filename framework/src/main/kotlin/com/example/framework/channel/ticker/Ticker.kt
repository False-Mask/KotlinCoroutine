package com.example.framework.channel.ticker

import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 *@author ZhiQiang Tu
 *@time 2022/1/30  10:34
 *@signature 我将追寻并获取我想要的答案
 */


fun main(): Unit = runBlocking {
    val ticker = ticker(100, 0)
    var nextElement = withTimeoutOrNull(1) { println(ticker.receive()) }
    nextElement = withTimeoutOrNull(50) { println(ticker.receive()) }
    withTimeoutOrNull(50) { println(ticker.receive()) }
}

