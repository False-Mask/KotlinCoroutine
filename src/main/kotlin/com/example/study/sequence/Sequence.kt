package com.example.study.sequence

/**
 *@author ZhiQiang Tu
 *@time 2022/1/18  16:50
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {
    val  iterator = sequence<Int> {
        var pre = 1
        var current = 1
        yield(pre)
        yield(current)
        for (i in 0..20){
            yield(pre+current)
            val tmp = pre
            pre = current
            current += tmp
        }
    }
    for (i in iterator){
        println(i)
    }
}