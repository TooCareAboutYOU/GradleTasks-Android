//import groovy.lang.GroovyClassLoader
//import groovy.lang.GroovyObject
//import groovy.util.GroovyScriptEngine
//import java.io.File
//import java.util.Objects
//
///**
// *
// * @author zhangshuai
// * @date 2023/8/9 13:42
// * @mark 自定义类描述
// */
//object GroovyHelper {
//
//    private const val PATH_GROOVY_FILE =
//        "/Users/zhangshuai/Project____/Android/GradleTasks-Android/lib_groovy/src/main/groovy/"
//
//    @JvmStatic
//    private val root = arrayOf(PATH_GROOVY_FILE)
//
//    @JvmStatic
//    private val engine: GroovyScriptEngine = GroovyScriptEngine(root)
//
//    @JvmStatic
//    private val classLoader = GroovyHelper::class.java.classLoader
//
//    @JvmStatic
//    private val gCLoader: GroovyClassLoader = GroovyClassLoader(classLoader)
//
//    /**
//     * 用于调用指定groovy脚本中的指定方法
//     */
//    @JvmStatic
//    fun invokeMethod(scriptName: String, methodName: String, vararg params: String): Objects {
//        val objects: Objects?
//        val scriptInstance: GroovyObject?
//        try {
//            val scriptClass = engine.loadScriptByName(scriptName)
//            scriptInstance = scriptClass.newInstance() as GroovyObject
//        } catch (e: Exception) {
//            throw Exception("加载脚本{ $scriptName }失败")
//        }
//
//        try {
//            objects = scriptInstance.invokeMethod(methodName, params) as Objects
//        } catch (e: Exception) {
//            throw Exception("调用方法[ $methodName ]失败，因参数不合法");
//        }
//        return objects
//    }
//
//    /**
//     * 接口调用
//     * groovy全名，包括后缀，例如下:
//     * FooGroovy.groovy
//     */
//    @JvmStatic
//    fun invokeMethod(fileName: String): IFoo? {
//        return try {
//            val path = PATH_GROOVY_FILE + fileName
//            val file = File(path)
//            if (!file.exists()) {
//                println("文件不存在")
//            }
//            val gClass = gCLoader.parseClass(file)
//            gClass.newInstance() as IFoo
//        } catch (e: Exception) {
//            e.printStackTrace()
//            null
//        }
//    }
//}