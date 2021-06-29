package com.example.usecoroutine.unit_4_6_29

import java.lang.Exception

/**
 *@author ZhiQiang Tu
 *@time 2021/6/29  21:45
 *我将追寻并获取我想要的答案
 */
class Unit5_6_29{
}

fun main(){
    val x
}

sealed class CoroutineState{
    class InComplete : CoroutineState()
    class Cancelling : CoroutineState()
    class Complete<T>(val value: T? = null,val exception: Throwable? =null) : CoroutineState()
}