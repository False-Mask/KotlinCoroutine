import kotlinx.coroutines.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

var continuation1: Continuation<Unit>? = null
var continuation2: Continuation<Unit>? = null
suspend fun main() {
    runBlocking {
        launch {
            while (true) {
                suspend2()
            }
        }

        launch {
            while (true) {
                suspend1()
            }
        }
    }
}

suspend fun suspend1() = suspendCoroutine<Unit> { continuation ->
    continuation1 = continuation
    println("Continuation1->"+Thread.currentThread().hashCode())
    continuation2?.resume(Unit)
}

suspend fun suspend2() = suspendCoroutine<Unit> { continuation ->
    continuation2 = continuation
    println("Continuation2->"+Thread.currentThread().hashCode())
    continuation1?.resume(Unit)

}
