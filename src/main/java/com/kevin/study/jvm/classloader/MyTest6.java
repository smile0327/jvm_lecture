package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:  类的加载
 *  1、准备阶段赋默认值
 *  2、初始化阶段赋指定的值
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 9:22 2019/8/14
 * @ProjectName: jvm_lecture
 */
public class MyTest6 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1 : " + Singleton.counter1);
        System.out.println("counter2 : " + Singleton.counter2);
    }

}


class Singleton{

    public static int counter1 = 1;

    private static Singleton singleton = new Singleton();

    private Singleton(){
        counter1 ++;
        counter2 ++;    //准备阶段的意义
        System.out.println(counter1);
        System.out.println(counter2);
    }

    public static int counter2 = 0;

    public static Singleton getInstance(){
        return singleton;
    }

}
