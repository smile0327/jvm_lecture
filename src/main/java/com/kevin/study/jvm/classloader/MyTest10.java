package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 8:42 2019/8/28
 * @ProjectName: jvm_lecture
 */
public class MyTest10 {

    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {
        Parent2 parent2;
        System.out.println("----------------");
        parent2 = new Parent2();
        System.out.println("----------------");
        System.out.println(Parent2.a);
        System.out.println("----------------");
        System.out.println(Child2.b);
    }

}


class Parent2{
    static  int a = 3;
    static {
        System.out.println("Parent2 static block");
    }
}

class Child2 extends Parent2{
    static int b = 4;
    static {
        System.out.println("Child2 static block");
    }
}