package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:  类的加载
 *  -XX:+TraceClassLoading  用于追踪类的加载信息并打印出来
 *
 *  -XX:+<option> 表示开启option选项
 *  -XX:-<option> 表示关闭option选项
 *  -XX:<option>=<value>  表示将option选项的值设置为value
 *
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 8:52 2019/8/8
 * @ProjectName: jvm_lecture
 */
public class MyTest1 {

    public static void main(String[] args) {

        /*
            输出结果：
            MyParent1 static block
            hello world
            原因分析：
            对于静态字段来说，只有直接定义了该字段的类才会被初始化；此时MyChild1是还没有初始化的
         */
        System.out.println(MyChild1.str);


        /*
            输出结果：
            MyParent1 static block
            MyChild1 static block
            welcome MyChild1
            原因分析：
            当一个类在初始化时，要求其父类全部都已经初始化完毕了
         */
//        System.out.println(MyChild1.str2);
    }

}


class MyParent1{

    public static String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }

}

class MyChild1 extends  MyParent1{

    public static String str2 = "welcome MyChild1";

    static {
        System.out.println("MyChild1 static block");
    }
}