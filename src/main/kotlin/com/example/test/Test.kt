package com.example.test

import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

/**
 *@author ZhiQiang Tu
 *@time 2022/1/24  13:08
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {
    GlobalScope.launch {
        println(Thread.currentThread().name)
        withContext(Dispatchers.IO){
            delay(1000)
        }
        println(Thread.currentThread().name)
        println(Thread.currentThread().name)
        withContext(Dispatchers.IO){
            delay(1000)
        }
        println(Thread.currentThread().name)
    }
    Thread.sleep(10000000)
}



