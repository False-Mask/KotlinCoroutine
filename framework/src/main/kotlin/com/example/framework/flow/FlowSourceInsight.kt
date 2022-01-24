package com.example.study.flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2021/11/28  21:36
 *@signature 我将追寻并获取我想要的答案
 */
class FlowSourceInsight {
}

fun main() {
    runBlocking {
        flow<Int> {
            emit(1)
            emit(2)
            emit(3)
        }
            .onEach {
                println("This is $it")
            }.collect()
    }
}

suspend fun c(){

}