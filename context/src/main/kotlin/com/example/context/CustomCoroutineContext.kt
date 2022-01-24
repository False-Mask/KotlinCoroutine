package com.example.context

import kotlinx.coroutines.CoroutineName
import kotlin.coroutines.*

/**
 *@author ZhiQiang Tu
 *@time 2022/1/21  19:10
 *@signature 我将追寻并获取我想要的答案
 */
//way1
data class CustomCoroutineContext1(
    val content: String
) : AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<CustomCoroutineContext1>
}

//way2
open class CustomCoroutineContext2(
    val content: String,
) : AbstractCoroutineContextElement(MyCustomCoroutine), MyCustomCoroutine {
    @OptIn(ExperimentalStdlibApi::class)
    companion object Key : AbstractCoroutineContextKey<MyCustomCoroutine, CustomCoroutineContext2>(MyCustomCoroutine,
        { it as? CustomCoroutineContext2 })
}

class CustomCoroutineContext3(
    val content1: String,
) : CustomCoroutineContext2(content1) {

    @OptIn(ExperimentalStdlibApi::class)
    companion object Key :
        AbstractCoroutineContextKey<CustomCoroutineContext2, CustomCoroutineContext3>(CustomCoroutineContext2,
            { it as? CustomCoroutineContext3 })
}

interface MyCustomCoroutine : CoroutineContext.Element {
    companion object Key : CoroutineContext.Key<MyCustomCoroutine>

    @OptIn(ExperimentalStdlibApi::class)
    override operator fun <E : CoroutineContext.Element> get(key: CoroutineContext.Key<E>): E? {
        return getPolymorphicElement(key)
    }
}

fun main() {
    val x =  CoroutineName("") + CustomCoroutineContext2("")
    println(x[CustomCoroutineContext3])
}