package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 15:31 2020/7/28
 * @ProjectName: jvm_lecture
 */
public class MyTest22 {

    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {
        /*
            默认这两个类都是由系统类加载器加载，如果改变系统参数java.ext.dirs（扩展类加载器加载路径）为classpath路径，
            输出仍然是应用类加载器加载的；原因是扩展类加载器是加载指定路径下的jar包，不是直接加载路径下的class，所以如果
            需要扩展类加载器加载，则需要将对应的class打包成jar包
         */
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }

}
