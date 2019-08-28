package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 8:54 2019/8/28
 * @ProjectName: jvm_lecture
 */
public class MyTest11 {

    public static void main(String[] args) {
        //对于静态字段来说，只有直接定义了该字段的类才会被初始化
        //所以此处Child3不会初始化
        System.out.println(Child3.a);
        Child3.doSomething();
    }

}


class Parent3{
    static int a = 3;

    static {
        System.out.println("Parent3 static block");
    }

    static void doSomething(){
        System.out.println("do something");
    }

}

class Child3 extends Parent3{
    static {
        System.out.println("Child3 static block");
    }
}