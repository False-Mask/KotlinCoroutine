package com.example.study.sequence


/**
 *@author ZhiQiang Tu
 *@time 2022/1/19  10:00
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {
    val sequence = sequence<Int> {
        yield(1)
        yield(2)
        yield(3)
    }
    for (i in sequence){
        println(i)
    }
}