package com.example.framework.flow.cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 *@author ZhiQiang Tu
 *@time 2022/1/26  22:25
 *@signature 我将追寻并获取我想要的答案
 */
fun main(): Unit = runBlocking {
    withTimeoutOrNull(1000){
        flow<Int> {
            repeat(20){
                delay(100)
                emit(it)
            }
        }.collect {
            println(it)
        }
    }
}