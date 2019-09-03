package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:  类加载器 - 双亲委派模型
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 7:37 2019/9/3
 * @ProjectName: jvm_lecture
 */
public class MyTest13 {

    public static void main(String[] args) {
        //系统类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (classLoader != null){
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }

}
