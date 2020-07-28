package com.kevin.study.jvm.classloader;

import java.lang.reflect.Method;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 11:00 2020/7/28
 * @ProjectName: jvm_lecture
 */
public class MyTest21 {

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        loader1.setPath("D:\\study\\jvm\\");
        loader2.setPath("D:\\study\\jvm\\");

        Class<?> clazz1 = loader1.loadClass("com.kevin.study.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.kevin.study.jvm.classloader.MyPerson");

        /*
            如果是由MyTest16加载器加载的class，那么两个MyPerson是不一样的（命名空间）；那么在执行setMyPerson方法时，
            会抛出ClassCastException异常，虽然两个class的包名相同，但是是不同命名空间中的两个class
         */
        System.out.println("class1 classLoader:" + clazz1.getClassLoader() + ", class1:" + clazz1.hashCode());
        System.out.println("class2 classLoader:" + clazz2.getClassLoader() + ", class2:" + clazz2.hashCode());
        System.out.println(clazz1 == clazz2);

        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(o1 , o2);
    }

}
