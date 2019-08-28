package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 9:10 2019/8/28
 * @ProjectName: jvm_lecture
 */
public class MyTest12 {

    public static void main(String[] args) throws ClassNotFoundException {
        //了解ClassLoader doc文档
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        // ClassLoader.loadClass方法加载一个类时，并不是对类的主动使用，不会导致类的初始化
        Class<?> clazz = loader.loadClass("com.kevin.study.jvm.classloader.CL");
        System.out.println(clazz);
        System.out.println("--------------");
        // 通过反射加载类是对类的主动使用，会导致类的初始化，所以此处会打印静态块里面的东西
        clazz = Class.forName("com.kevin.study.jvm.classloader.CL");
        System.out.println(clazz);
    }

}

class CL{
    static {
        System.out.println("Class CL");
    }
}