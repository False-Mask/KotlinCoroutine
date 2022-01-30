package com.example.framework.flow.conflate

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/27  18:29
 *@signature 我将追寻并获取我想要的答案
 */

fun simple() = flow<Int> {
    repeat(3) {
        delay(100)
        emit(it)
    }
}.conflate()

fun main() = runBlocking {
    simple()
        .collect {
            delay(300)
            println("get ${it}")
        }
}



