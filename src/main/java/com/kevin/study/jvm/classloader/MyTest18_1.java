package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 9:46 2020/7/28
 * @ProjectName: jvm_lecture
 */
public class MyTest18_1 {

    public static void main(String[] args) throws ClassNotFoundException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("D:\\study\\jvm\\");
        Class<?> clazz = loader1.loadClass("com.kevin.study.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        System.out.println("class loader:" + clazz.getClassLoader());
    }

}
