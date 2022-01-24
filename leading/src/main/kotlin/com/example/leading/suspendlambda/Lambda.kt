package com.example.leading.suspendlambda

import kotlinx.coroutines.delay

/**
 *@author ZhiQiang Tu
 *@time 2022/1/24  13:46
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
    a {int,str->
        println("before delay")
        delay(1000)
        println("after delay")
        println(str + int +this)
    }
}

suspend fun a(block: suspend String.(Int,String) -> Unit) {
    "1".block(1,"1")
}