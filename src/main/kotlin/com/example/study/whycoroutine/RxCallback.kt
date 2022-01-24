package com.example.study.whycoroutine

import io.reactivex.rxjava3.core.Observable

/**
 *@author ZhiQiang Tu
 *@time 2022/1/13  23:43
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {
    Observable.create<Unit> {
        it.onNext(Unit)
    }.flatMap {
        Observable.create<Unit> { it.onNext(taskA {}) }
    }.flatMap {
        Observable.create<Unit> { it.onNext(taskB {}) }
    }.flatMap {
        Observable.create<Unit> {
            it.onNext(taskC {})
        }
    }.subscribe {
        println("好了这样完成了A->B->C的异步任务")
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

