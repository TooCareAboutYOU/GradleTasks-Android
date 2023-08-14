package com.zs.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class BuildSrcGradlePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        System.out.println("插件构建成功了")
    }
}