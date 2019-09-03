package com.kevin.study.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 7:52 2019/9/3
 * @ProjectName: jvm_lecture
 */
public class MyTest14 {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // 本地磁盘路径资源
        String resourceName = "com/kevin/study/jvm/classloader/MyTest13.class";

        //通过本地资源加载
        Enumeration<URL> resources = classLoader.getResources(resourceName);

        while (resources.hasMoreElements()){
            URL url = resources.nextElement();
            System.out.println(url);
        }

        System.out.println("----------------");

        Class<?> clazz = MyTest14.class;
        System.out.println(clazz.getClassLoader());

    }
}
