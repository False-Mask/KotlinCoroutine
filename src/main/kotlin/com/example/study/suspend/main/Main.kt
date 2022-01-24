package com.example.study.suspend.main

import kotlinx.coroutines.delay

/**
 *@author ZhiQiang Tu
 *@time 2022/1/16  9:04
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
    a()
    a()
}

suspend fun a(){
    println("before com.example.study.delay")
    delay(1000)
    println("after com.example.study.delay")
}