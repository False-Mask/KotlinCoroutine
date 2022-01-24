import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

/**
 *@author ZhiQiang Tu
 *@time 2021/11/10  10:37
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
    flow<Int> {
        println("producer:"+Thread.currentThread().name)
        emit(1)
        println("producer:"+Thread.currentThread().name)
        emit(2)
    }
        //.flowOn(Dispatchers.IO)
        .onEach {
            println("consumer:$it")
            println("consumer:"+Thread.currentThread().name)
        }
        .collect {  }
        //.launchIn(CoroutineScope(Dispatchers.Default))
        //.join()

}