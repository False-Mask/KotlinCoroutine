package com.example.study.delay

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/1/16  20:27
 *@signature 我将追寻并获取我想要的答案
 */

/*
com.example.study.suspend fun main() {
    println("before com.example.study.delay-->"+Thread.currentThread().name)
    com.example.study.delay(1000)
    println("after com.example.study.delay -->"+Thread.currentThread().name)
    println("before com.example.study.delay-->"+Thread.currentThread().name)
    com.example.study.delay(1000)
    println("after com.example.study.delay -->"+Thread.currentThread().name)
}*/

/*
com.example.study.suspend fun main(){
    for (i in 0..100){
        println(Thread.currentThread().name  + Thread.currentThread().hashCode())
        com.example.study.delay(1000)
        Thread.sleep(10000)
        println(Thread.currentThread().name  + Thread.currentThread().hashCode())
    }
}*/

fun main(){
    runBlocking {
        launch {
            while (true){
                delay(1000)
                println("我恢复执行了我要抛出一个异常")
                println(10 / 0)
                println("我还活着惊不惊喜")
            }
        }
        launch {
            delay(500)
            while (true){
                delay(1000)
                println("我恢复执行了我要抛出一个异常")
            }
        }
    }
}
