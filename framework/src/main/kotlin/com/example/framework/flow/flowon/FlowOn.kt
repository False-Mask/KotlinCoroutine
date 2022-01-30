package com.example.framework.flow.flowon

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/27  9:29
 *@signature 我将追寻并获取我想要的答案
 */

fun main(): Unit = runBlocking {
    simple().flowOn(Dispatchers.Default).collect {
        println(Thread.currentThread().name)
    }
}

fun simple() = flow<Int> {
    repeat(100) {
        delay(1000)
        println(Thread.currentThread().name)
        emit(it)
    }
}
