package com.kevin.study.jvm.classloader;

import java.util.Random;

/**
 * @Auther: kevin
 * @Description: 当一个接口在初始化时，并不要求其父接口都完成了初始化；
 * 只有在真正使用到父接口的时候（如引用父接口中所定义的常量时），才会初始化
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 8:59 2019/8/14
 * @ProjectName: jvm_lecture
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5 {
    //接口中定义的常量默认就是 public static final 修饰的 可以省略不写
    public static int a = 5;
    //    public static int a = new Random().nextInt(5);
    public static Thread thread = new Thread() {
        //代码块  创建该对象的实例时就会执行
        {
            System.out.println("MyParent5 invoked");
        }
    };
}

class MyChild5 implements MyParent5 {
    public static int b = 6;
//    public static int b = new Random().nextInt(4);
}