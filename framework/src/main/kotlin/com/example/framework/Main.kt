package com.example.framework

import okhttp3.*
import java.io.IOException

/**
 *@author ZhiQiang Tu
 *@time 2022/1/29  22:38
 *@signature 我将追寻并获取我想要的答案
 */

fun main() {
    val okhttp = OkHttpClient()

    val request = Request.Builder()
        .url("https://www.wanandroid.com/user/login")
        .post(
            FormBody.Builder()
                .add("username", "zhiqiangtu")
                .add("password", "1234567890")
                .build()
        )
        .build()

    okhttp.newCall(request)
        .enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}

            override fun onResponse(call: Call, response: Response) {
                var strBuilder = ""
                for (it in response.headers){
                    if (it.first == "Set-Cookie"){
                        strBuilder += it.second+";"
                    }
                }
                println(strBuilder)

                okhttp.newCall(
                    Request.Builder()
                        .url("https://wanandroid.com/user/lg/userinfo/json")
                        .get()
                        .addHeader("Cookie", strBuilder.toString())
                        .build()
                ).enqueue(
                    object : Callback {
                        override fun onFailure(call: Call, e: IOException) {}

                        override fun onResponse(call: Call, response: Response) {
                            println(response.body?.byteString())
                        }
                    }
                )
            }

        })

    Thread.sleep(10000)

}


