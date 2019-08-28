package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 8:32 2019/8/28
 * @ProjectName: jvm_lecture
 */
public class MyTest9 {

    static {
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
    }

}


class Parent{
    static  int a = 3;
    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent{
    static int b = 4;
    static {
        System.out.println("Child static block");
    }
}