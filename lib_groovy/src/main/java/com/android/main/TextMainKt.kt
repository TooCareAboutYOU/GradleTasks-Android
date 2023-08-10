package com.android.main

import groovy.json.JsonSlurper

/**
 *
 * @author zhangshuai
 * @date 2023/8/10 16:11
 * @mark 自定义类描述
 */
class TextMainKt {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val jsonStr = "{\"name\":\"Tom\",\"age\":20,\"friends\":[\"Jerry\",\"Spike\"]}"
            val json = JsonSlurper().parseText(jsonStr)
            System.out.println("nam：$json");
        }
    }
}