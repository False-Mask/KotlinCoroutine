/**
 *@author ZhiQiang Tu
 *@time 2022/1/13  23:03
 *@signature 我将追寻并获取我想要的答案
 */

fun main() {
    taskA{
        taskB{
            taskC{
                println("好了这样完成了A->B->C的异步任务")
            }
        }
    }
}
fun interface TaskABack {
    fun taskAFinished()
}

fun interface TaskBBack {
    fun taskBFinished()
}
fun interface TaskCBack {
    fun taskCFinished()
}

fun taskA(taskABack: TaskABack) {
    println("taskA开始")
    Thread.sleep(1000)
    println("taskA结束了")
    taskABack.taskAFinished()
}

fun taskB(taskBBack: TaskBBack) {
    println("taskB开始")
    Thread.sleep(1000)
    println("taskB结束了")
    taskBBack.taskBFinished()
}

fun taskC(taskCBack: TaskCBack) {
    println("taskC开始")
    Thread.sleep(1000)
    println("taskC结束了")
    taskCBack.taskCFinished()
}