package com.example.framework.flow.map

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/26  22:36
 *@signature 我将追寻并获取我想要的答案
 */

fun main(): Unit = runBlocking {
    flow<Int> {
        emit(1)
        emit(2)
        emit(3)
    }
        .transform {
            emit(it.toString())
        }.collect {
            println(it)
        }

    flow<Int> {
        emit(1)
    }.map {
        it.toString()
    }.collect {
        println(it)
    }
}

