package com.closure.plugin

import com.closure.plugin.ext.IPluginExtension
import com.closure.plugin.ext.PluginExtension
import com.closure.plugin.ext.ConfigPluginExtensions
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 自定义闭包插件
 * @author zhangshuai
 * @date 2023/8/5 14:17
 */
class MyClosurePlugin : Plugin<Project> {

    private val pluginTaskName = "closurePlugin"
    private val groupId = "plugin closure"

    private val myClosure = "myClosure"
    private val myClosureImpl = "myClosureImpl"
    private val configClosure = "configClosure"

    private lateinit var extension: PluginExtension
    private lateinit var extensionImpl: IPluginExtension
    private lateinit var configExtension: ConfigPluginExtensions


    override fun apply(project: Project) {

        println("初始化插件....")

        //方式一
        extension = project.extensions.create(myClosure, PluginExtension::class.java)

        //方式二
        extensionImpl = project.extensions.create(myClosureImpl, IPluginExtension::class.java)

        //方式三
        configExtension = project.extensions.create(configClosure, ConfigPluginExtensions::class.java)

        project.afterEvaluate {
            it.tasks.matching { task ->
                configExtension.name == task.name
            }.forEach { task ->
                println("输出配置：${configExtension.path}")
                task.finalizedBy(pluginTaskName)
                createTask(it)
            }
        }
    }

    private fun createTask(project: Project) {
        project.task(pluginTaskName) {
            println("配置task：${configExtension.name}")
            it.dependsOn(configExtension.name)
            it.group = groupId
            it.doFirst {
                println("pluginName.doFirst.....")
                println("获取：${extension.getMessage().get()}")
            }

            it.doLast {
                println("pluginName.doLast.....")
                println("获取：message= ${extensionImpl.getMessage().get()}")
                println("获取：greeter= ${extensionImpl.getGreeter().get()}")
                println("打印文件路径：path= ${configExtension.path}")
            }
        }
    }
}