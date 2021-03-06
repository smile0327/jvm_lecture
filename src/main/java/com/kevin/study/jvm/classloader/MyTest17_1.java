package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 14:47 2020/7/27
 * @ProjectName: jvm_lecture
 */
public class MyTest17_1 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("D:\\study\\jvm\\");

        Class<?> clazz = loader1.loadClass("com.kevin.study.jvm.classloader.MySample");
        System.out.println("class:" + clazz.hashCode());

        /*
            如果不实例化MySample对象，即MySample构造方法不会被调用，因此不会实例化MyCat对象，
            即没有对MyCat进行主动使用，这里就不会加载MyCat Class
         */
        Object object = clazz.newInstance();
    }

}
