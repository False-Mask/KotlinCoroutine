package com.example.framework.flow.buffer

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/27  9:36
 *@signature 我将追寻并获取我想要的答案
 */

fun main() = runBlocking<Unit>{

    simple()
        .collect {
            println("collect ${it}")
            delay(1000)
        }

}

fun simple() = flow<Int>{
    repeat(100){
        delay(100)
        println("emit $it")
        emit(it)
    }
}
    .flowOn(Dispatchers.Default)
    .buffer()


