package com.kevin.study.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 10:03 2020/7/28
 * @ProjectName: jvm_lecture
 */
public class MyTest19 {

    public static void main(String[] args) {
        /*
            该类在扩展类加载器的加载目录下，由结果可以观察到是由扩展类加载器加载的
            注意：扩展类加载加载目录是java.ext.dirs参数指定得目录，如果将系统变量java.ext.dirs指定的目录更改，运行
            此程序则会报错ClassNotFoundException
            例如： java -Djava.ext.dirs=./  com.kevin.study.jvm.classloader.MyTest19   更改为当前目录执行MyTest19.class
         */
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        //MyTest19由应用类加载器加载
        System.out.println(MyTest19.class.getClassLoader());
    }

}
