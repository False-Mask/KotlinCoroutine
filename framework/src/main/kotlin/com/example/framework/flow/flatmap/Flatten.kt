package com.example.framework.flow.flatmap

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/28  11:46
 *@signature 我将追寻并获取我想要的答案
 */

fun main(): Unit = runBlocking {
    flow<Int> {
        repeat(10) {
            emit(it)
            delay(100)
        }
    }
        .flatMapLatest{
            produceFlow(it)
        }
        .collect {
            println(it)
        }
}


fun produceFlow(value: Int) = flow<String> {
    repeat(10) {
        delay(1000)
        emit(value.toString() + it.toString())
    }
}


