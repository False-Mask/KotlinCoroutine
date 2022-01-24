import kotlinx.coroutines.*

/**
 *@author ZhiQiang Tu
 *@time 2022/1/20  10:40
 *@signature 我将追寻并获取我想要的答案
 */

suspend fun main() {
    a {
        println("=====before delay=====")
        delay(1000)
        println("=====after delay=====")
    }
}
suspend fun a(block: suspend ()->Unit){
    block()
}




