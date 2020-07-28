package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 16:54 2020/7/27
 * @ProjectName: jvm_lecture
 */
public class MyTest18 {

    public static void main(String[] args) {
        //启动类加载器 加载路径
        System.out.println("Bootstrap ClassLoader loader path:" + System.getProperty("sun.boot.class.path"));
        //扩展类加载器 加载路径
        System.out.println("Extension ClassLoader loader path:" + System.getProperty("java.ext.dirs"));
        //系统类（应用类）加载器  加载路径
        System.out.println("App ClassLoader loader path:" + System.getProperty("java.class.path"));
    }
}
