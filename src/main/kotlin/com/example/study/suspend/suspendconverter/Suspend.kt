import kotlinx.coroutines.*
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 *@author ZhiQiang Tu
 *@time 2021/12/2  23:16
 *@signature 我们不明前路，却已在路上
 */
fun interface SingleMethodCallback {
    fun onCallback(value: String)
}

fun runTask(callback: SingleMethodCallback) {
    thread {
        //blocking
        Thread.sleep(1000)
        //Callback
        callback.onCallback("Callback")
    }
}

suspend fun runTaskSuspend() = suspendCoroutine<String> { continuation ->
    println(Thread.currentThread().name)
    runTask {
        println(Thread.currentThread().name)
        continuation.resume(it)
    }
}


interface Callback2 {
    fun success(str: String)
    fun error(throwable: Throwable)
}

fun taskRun2(callback2: Callback2) {
    thread {
        try {
            Thread.sleep(1000)
            callback2.success("Callback2")
        } catch (e: Exception) {
            callback2.error(e)
        }
    }
}

suspend fun runTaskSuspend2() = suspendCoroutine<String> {
    taskRun2(object : Callback2 {
        override fun success(str: String) {
            it.resume(str)
        }

        override fun error(throwable: Throwable) {
            it.resumeWithException(throwable)
        }

    })
}


interface Callback3 {
    fun success(str: String)
    fun error(throwable: Throwable)
}

fun interface Cancel {
    fun cancel()
}

fun runTask3(callback3: Callback3): Cancel {
    val thread = thread {
        Thread.sleep(1000)
        try {
            callback3.success("12")
        } catch (e: Exception) {
            callback3.error(e)
        }
    }

    return Cancel {
        thread.interrupt()
    }
}

suspend fun runTaskSuspend3() = suspendCancellableCoroutine<String> {
    val job = runTask3(object : Callback3 {
        override fun success(str: String) {
            it.resume(str)
            println("success")
        }

        override fun error(throwable: Throwable) {
            it.resumeWithException(throwable)
            println("Error")
        }

    })

    it.invokeOnCancellation {
        job.cancel()
        println("任务已经取消")
    }
}


interface Callback4 {
    fun pre()
    fun doing()
    fun progress(progress: Int)
    fun finish()
    fun end()
    fun error(throwable: Throwable)
}

fun runTask4(callback4: Callback4) {
    thread {
        try {
            callback4.pre()
            callback4.doing()
            var progress = 0
            while (progress < 100) {
                progress += 20
                Thread.sleep(100)
                callback4.progress(progress)
            }
            callback4.progress(100)
            callback4.finish()
            callback4.end()
        } catch (e: Exception) {
            callback4.error(e)
        }
    }
}

sealed class Event {
    object Pre : Event()
    object Doing : Event()
    class Progress(str: Int) : Event()
    object Finish : Event()
    object End : Event()
    class Error(throwable: Throwable) : Event()
}

fun runTaskSuspend4() = callbackFlow<Event> {
    runTask4(object : Callback4 {
        override fun pre() {
            trySend(Event.Pre)
        }

        override fun doing() {
            trySend(Event.Doing)
        }

        override fun progress(progress: Int) {
            trySend(Event.Progress(progress))
        }

        override fun finish() {
            trySend(Event.Finish)
        }

        override fun end() {
            trySend(Event.End)
        }

        override fun error(throwable: Throwable) {
            trySend(Event.Error(throwable))
        }

    })
}


suspend fun main() {
    runTaskSuspend4().collect {

    }
}








