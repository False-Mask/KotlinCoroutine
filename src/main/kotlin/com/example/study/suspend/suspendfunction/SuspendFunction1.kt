import kotlinx.coroutines.delay

/**
 *@author ZhiQiang Tu
 *@time 2022/1/11  10:11
 *@signature 我将追寻并获取我想要的答案
 */

suspend fun main() {
    suspendFunc()
    suspendFunc()
    suspendFunc()
    suspendFunc()
    suspendFunc()
}

suspend fun suspendFunc(): Int {
    println("before com.example.study.delay:" + Thread.currentThread().name)
    delay(1000)
    println("after com.example.study.delay:" + Thread.currentThread().name)
    return 1
}

