package com.example.leading.whycoroutine

import kotlinx.coroutines.delay

/**
 *@author ZhiQiang Tu
 *@time 2022/1/14  10:58
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
    testFun1()
    testFun1()
    testFun1()
    testFun1()
    testFun1()
    testFun1()
    testFun1()
    testFun1()
    testFun1()
}

suspend fun testFun1() {
    println("before delay")
    delay(1000)
    println("after delay")
}