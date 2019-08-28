package com.kevin.study.jvm.classloader;

import java.util.UUID;

/**
 * @Auther: kevin
 * @Description:
 *
 *  当一个常量的值并非编译器可以确定的，那么其值就不会被放到调用类的常量池中，这时在程序运行时，
 *  会导致主动使用这个常量所在的类，显然会导致初始化这个类
 *
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 8:08 2019/8/14
 * @ProjectName: jvm_lecture
 */
public class MyTest3 {

    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }

}


class MyParent3{

    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static block");
    }

}