package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:  类加载器
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 9:20 2019/8/20
 * @ProjectName: jvm_lecture
 */
public class MyTest7 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        // 返回null  由根类加载器加载
        System.out.println(clazz.getClassLoader());

        Class<?> cClazz = Class.forName("com.kevin.study.jvm.classloader.C");
        //应用类加载器加载
        System.out.println(cClazz.getClassLoader());

    }

}


class C {

}