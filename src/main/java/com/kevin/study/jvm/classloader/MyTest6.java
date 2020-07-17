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
        //1、访问静态方法，对类的主动使用
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1 : " + singleton.counter1);
        System.out.println("counter2 : " + singleton.counter2);
    }

}


class Singleton{

    /*
        准备阶段对静态变量初始化默认值
        counter1 = 0;
        counter2 = 0;
        singleton = null;
     */

    public static int counter1 = 1;

    //准备阶段为null，初始化的时候就需要new 一个实例，调用构造器
    private static Singleton singleton = new Singleton();

    private Singleton(){
        /*
            准备阶段会为静态变量初始化默认值，
            初始化会按照从上到下的顺序初始化。
            此时counter1 的值是初始化之后的值，但是counter2 还没初始化，因此使用的是准备阶段的默认值
         */
        counter1 ++;
        counter2 ++;
        System.out.println(counter1);
        System.out.println(counter2);
    }

    //初始化顺序是从上到下，也就是初始化的时候会在这里将counter2 的值初始化为0
    public static int counter2 = 0;

    /*
        2、调用静态方法，对类的主动使用，会导致类的初始化
        初始化之前会先进行类的连接（准备阶段初始化默认值）
     */
    public static Singleton getInstance(){
        return singleton;
    }

}
