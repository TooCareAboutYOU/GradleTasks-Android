package com.closure.plugin.ext

import org.gradle.api.provider.Property

/**
 * 自定义闭包扩展属性
 * @author zhangshuai
 * @date 2023/8/5 14:34
 */
abstract class PluginExtension {
    abstract fun getMessage(): Property<String>
}