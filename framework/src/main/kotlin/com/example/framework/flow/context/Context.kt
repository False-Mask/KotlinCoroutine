package com.example.framework.flow.context

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 *@author ZhiQiang Tu
 *@time 2022/1/27  9:19
 *@signature 我将追寻并获取我想要的答案
 */

fun main():Unit = runBlocking {
    withContext(coroutineContext){
        simple().collect {
            println(it)
        }
    }
}

fun simple() = flow<Int> {
    repeat(100){
        emit(it)
    }
}


