package com.example.framework.flow.catchexception

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/28  12:27
 *@signature 我将追寻并获取我想要的答案
 */

fun main(): Unit = runBlocking {

    flow<Int> {
        emit(1)
        emit(0)
        repeat(10) {
            emit(it + 1)
        }
    }
        .map {
            1 / it
        }
        .catch { e ->
            println("error: ${e}")
            emit(1)
        }
        .collect {
            println("suscess:$it")
        }

}


