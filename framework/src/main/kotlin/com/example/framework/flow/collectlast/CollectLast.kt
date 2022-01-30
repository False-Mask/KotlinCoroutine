package com.example.framework.flow.collectlast

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/27  18:43
 *@signature 我将追寻并获取我想要的答案
 */


fun simple() = flow<Int> {
    repeat(10){
        delay(100)
        emit(it)
    }
}


fun main():Unit = runBlocking {
    simple()
        .collectLatest {
            delay(300)
            println(it)
        }
}