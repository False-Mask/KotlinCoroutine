import kotlinx.coroutines.delay
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 *@author ZhiQiang Tu
 *@time 2021/12/3  22:50
 *@signature 我将追寻并获取我想要的答案
 */

suspend fun falseSuspend01(){
    println("false")
}

suspend fun falseSuspend02(){
    thread {
        Thread.sleep(1000)
    }
    println("false")
}

suspend fun trueSuspend01(){
    delay(100)
    println("true")
}

suspend fun trueSuspend02() = suspendCoroutine<Unit> {
    thread {
        Thread.sleep(1000)
        it.resume(Unit)
    }
    println("true")
}

suspend fun falseSuspend03() = suspendCoroutine<Unit> {
    Thread.sleep(1000)
    println("false")
    it.resume(Unit)
}

suspend fun falseSuspend04() = suspendCoroutine<Unit> {
    thread {
        Thread.sleep(1000)
    }
    println("hello")
    it.resume(Unit)
}
suspend fun main(){
    falseSuspend04()
}

