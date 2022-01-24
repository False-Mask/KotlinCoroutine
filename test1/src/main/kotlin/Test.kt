import com.test2.intrinsics.x
import kotlinx.coroutines.delay

/**
 *@author ZhiQiang Tu
 *@time 2022/1/22  12:26
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
    suspendTest {
        println("before delay")
        delay(1000)
        println("after delay")
    }
}

suspend fun suspendTest(block:suspend ()->Unit){
    block()
}