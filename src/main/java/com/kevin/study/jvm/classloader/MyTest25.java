package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 10:43 2020/7/30
 * @ProjectName: jvm_lecture
 */
public class MyTest25 implements Runnable{

    private Thread thread;

    public MyTest25() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        /*
            如果没有通过setContextClassLoader(ClassLoader cl)进行设置的话，线程将继承其父线程的上下文类加载器。
            Java应用运行时的初始线程的上下文类加载器是 系统类加载器。
         */
        ClassLoader classLoader = this.thread.getContextClassLoader();
        this.thread.setContextClassLoader(classLoader);
        System.out.println("Class:" + classLoader.getClass());
        System.out.println("Parent:" + classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new MyTest25();
    }

}
