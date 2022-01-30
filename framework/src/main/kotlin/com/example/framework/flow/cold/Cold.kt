package com.example.framework.flow.cold

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

/**
 *@author ZhiQiang Tu
 *@time 2022/1/26  22:23
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {
    simple()
}

fun simple() = flow<Int> {
    repeat(10){
        println("emit $it")
        emit(it)
        delay(1000)
    }
}