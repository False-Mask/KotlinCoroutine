package com.example.study.coroutinecontext

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlin.coroutines.EmptyCoroutineContext

/**
 *@author ZhiQiang Tu
 *@time 2022/1/21  10:20
 *@signature 我将追寻并获取我想要的答案
 */

fun main() {
    val context = EmptyCoroutineContext
    println(context.javaClass)

    val context1 = context + CoroutineName("Test")
    println(context1.javaClass)

    val context2 =
        context1 + CoroutineExceptionHandler { coroutineContext, throwable -> println(coroutineContext.toString() + throwable.toString()) }
    println(context2.javaClass)

    val context3 = context2 + Dispatchers.IO
    println(context3.javaClass)

    val context4 = context3 + NonCancellable
    println(context4.javaClass)
}