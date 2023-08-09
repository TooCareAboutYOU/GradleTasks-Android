/**
 * 配置脚本
 * 找到：Edit Configurations
 * 新增：groovy
 * 只需要填写 Name、Script path 就可以，Name 随便写，Script path 就选择上面 RunGroovy.Groovy 类的全路径。
 */

class Run {
    static void main(String[] args) {
        try {
            IFoo iFoo = GroovyHelper.invokeMethod("FooGroovy.groovy")
            int result = iFoo.run(99)
            println("输出结果：" + result)
        } catch (Exception e) {
            e.printStackTrace()
            println("异常：" + e)
        }
    }
}