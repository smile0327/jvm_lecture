package com.kevin.study.jvm.classloader;

import sun.misc.Launcher;

/**
 * @Auther: kevin
 * @Description:
 *    在运行期，一个Java类是由该类的完全限定名（binary name，二进制名）和用于加载该类的定义类加载器（defining loader）所决定的。
 *    如果同样名字（即相同的完全限定名）的类是由两个不同的加载器所加载，那么这些类就是不同的，即便.class文件字节码完全一样，并且
 *    从相同的位置加载亦如此。
 *
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 16:40 2020/7/28
 * @ProjectName: jvm_lecture
 */
public class MyTest23 {


    public static void main(String[] args) {
        //启动类加载器 加载路径
        /*
            如果系统属性sun.boot.class.path修改错了，则运行会报错：
            Error occurred during initialization of VM
            java/lang/NoClassDefFoundError: java/lang/Object
         */
        System.out.println("Bootstrap ClassLoader loader path:" + System.getProperty("sun.boot.class.path"));
        //扩展类加载器 加载路径
        System.out.println("Extension ClassLoader loader path:" + System.getProperty("java.ext.dirs"));
        //系统类（应用类）加载器  加载路径
        System.out.println("App ClassLoader loader path:" + System.getProperty("java.class.path"));

        /*
            内建于JVM中的启动类加载器会加载java.lang.ClassLoader以及其他的Java平台类；当JVM启动时，一块特殊的机器码会运行，
            它会加载扩展类加载器与系统类加载器，这块特殊的机器码叫做启动类加载器（Bootstrap）

            启动类加载器并不是Java类，而其他的加载器则都是Java类；启动类加载器时 特定于平台的机器指令，它负责开启整个加载过程。

            所有类加载器（除了启动类加载器）都被实现为Java类。不过，总归要有一个组件来加载第一个Java类加载器，从而让整个加载过程
            能够顺利进行下去，加载第一个纯Java类加载器就是启动类加载器的职责。

            启动类加载器还会负责加载供JRE正常运行所需要的基本组件，这包括java.util与java.lang包中的类等等。
         */
        System.out.println(ClassLoader.class.getClassLoader());

        /*
            扩展类加载器与系统类加载器也是由启动类加载器加载的。扩展类加载器和系统类加载器是Launcher类的静态内部类，
            Launcher是由启动类加载器加载的，那么其静态内部类也是由启动类加载器加载。
         */
        System.out.println(Launcher.class.getClassLoader());

        System.out.println("---------------------");

        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(MyTest23.class.getClassLoader());
        System.out.println(MyTest16.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());


    }

}
