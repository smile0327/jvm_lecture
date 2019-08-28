package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:  final修饰的常量
 *
 *  常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中，
 *  本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化
 *
 *  助记符：
 *  lcd：表示将int、float或者是String类型的常量值从常量池当中推送到栈顶
 *  bipush：表示将单字节(-128 ～127) 的常量值推送到栈顶
 *  sipush：表示将一个短整型常量值(-32768 ～32767) 推送至栈顶
 *  iconst_1：表示将int类型的数值1推送至栈顶 (iconst_m1 ～iconst_5) 当大于5或小于-1时变成了bipush
 *
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 9:02 2019/8/12
 * @ProjectName: jvm_lecture
 */
public class MyTest2 {

    public static void main(String[] args) {
        /*
            由于str是final修饰的常量，在编译阶段str这个常量就会存入到MyTest2的常量池中，之后MyTest2与MyParent2就没有任何关系了，
            甚至可以删除MyParent2的.class文件
            所以并没有引用到MyParent2这个类，MyParent2没有初始化，所以不会输出静态块中的内容，
            通过-XX:+TraceClassLoading  可以发现并没有加载MyParent2这个类

         */
        System.out.println(MyParent2.s);
    }

}


class MyParent2{

    public static final String str = "hello world";

    public static final short s = 128;

    public static final int i = 128;

    public static final int m = 1;

    static {
        System.out.println("MyParent2 static block");
    }

}