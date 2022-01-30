package com.example.framework.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/26  22:14
 *@signature 我将追寻并获取我想要的答案
 */


    fun simple() = flow<Int>{
        repeat(3){
            delay(300)
            emit(it)
        }
    }

    fun main(): Unit = runBlocking {
        launch {
            repeat(10){
                println("I am not blocked")
                delay(100)
            }
        }
        simple().collect {
            println("get:${it}")
        }
    }