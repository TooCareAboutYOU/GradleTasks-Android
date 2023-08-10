import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginStudy implements Plugin<Project> {

    /**
     * 唯一需要实现的就是这个方法，参数就是引入了当前插件的Project对象
     * @param project
     */
    @Override
    void apply(Project project) {
        project.group="aaa"
        project.extensions.create('imoocReleaseInfo', ReleaseInfoExtension)
        project.tasks.create('imoocReleaseInfoTask', ReleaseInfoTask)
        System.out.println("打印：${project.name}")
    }
}