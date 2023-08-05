package com.closure.plugin.ext

import org.gradle.api.provider.Property

/**
 * 自定义闭包扩展接口
 * @author zhangshuai
 * @date 2023/8/5 14:33
 */
interface IPluginExtension {

    fun getMessage(): Property<String>

    fun getGreeter(): Property<String>
}