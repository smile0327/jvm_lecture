package com.kevin.study.jvm.classloader;

import java.sql.Driver;
import java.util.ServiceLoader;

/**
 * @Auther: kevin
 * @Description:   线程上下文类加载器的使用方法
 *
 *  线程上下文类加载器的一般使用模式（获取- 使用 - 还原）
 *
 *  //1、获取当前线程的上下文类加载器
 *  ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 *
 *  try{
 *  //2、设置当前线程的上下文类加载器为目标的类加载器，然后做相关业务处理
 *      Thread.currentThread().setContextClassLoader(targetTcl);
 *      myMethod();
 *  }finally{
 *  //3、还原当前线程类加载器为原始的类加载器
 *      Thread.currentThread().setContextClassLoader(classLoader);
 *  }
 *
 *  myMethod方法里面调用Thread.currentThread().getContextClassLoader()，获取当前线程的上下文类加载器做某些事情。
 *  如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的（如果该依赖的类之前没有被加载过的话）
 *
 *  ContextClassLoader的作用就是为了破坏Java的类加载机制。
 *  当高层提供了统一的接口让低层去实现，同时又要在高层加载（或实例化）低层的类时，就必须要通过线程上下文类加载器
 *  来帮助高层的ClassLoader找到并加载该类。
 *
 *
 *
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 11:05 2020/7/30
 * @ProjectName: jvm_lecture
 */
public class MyTest26 {

    public static void main(String[] args) {
        /*
            如果设置当前线程上下文类加载器为加载MyTest26的加载器的父加载器（即扩展类加载器），下面代码执行的结果
            drivers将为空，由于ServiceLoader中加载相应的class时，是需要根据META-INF/services/查找相关的class（该
            class是在classPath下，需要由系统类加载器来加载，根据双亲委托机制，如果线程上下文类加载器设置成了扩展类
            加载器，那么是无法加载到classPath下的class的）
         */
        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());
        ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        drivers.forEach(driver -> {
            System.out.println("driver:" + driver.getClass() + ", loader:" + driver.getClass().getClassLoader());
        });
        System.out.println("Current Class loader:" + MyTest26.class.getClassLoader());
        System.out.println("Current Thread context classLoader:" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader classLoader:" + ServiceLoader.class.getClassLoader());
    }

}
