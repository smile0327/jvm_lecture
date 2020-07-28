package com.kevin.study.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: kevin
 * @Description:  自定义类加载器
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 11:25 2019/9/15
 * @ProjectName: jvm_lecture
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    //class类的路径
    private String path;

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        super();    //将系统类加载器当作该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);  //显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("class name : " + name);
        System.out.println("class loader : " + this.classLoaderName);
        byte[] data = this.loadClassData(name);
        return this.defineClass(name , data , 0 , data.length);
    }

    /**
     * 从指定路径加载文件
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream out = null;
        name = name.replace("." , "\\");
        try {
            is = new FileInputStream(new File(this.path + name + this.fileExtension));
            out = new ByteArrayOutputStream();
            int ch;
            while (-1 != (ch = is.read())){
                out.write(ch);
            }
            data = out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.kevin.study.jvm.classloader.MyTest1");
        Object instance = clazz.newInstance();  //创建类的实例
        //通过输出结果可以看到，MyTest1 是由应用类加载器加载的
        System.out.println(instance);
        System.out.println(instance.getClass().getClassLoader());
    }

    public static void main(String[] args) throws Exception {
        //MyTest16 的父类加载器就是系统类加载器，根据双亲委托机制，加载类时会先委托给父类加载器去加载
        MyTest16 loader1 = new MyTest16("loader1");
        /*
            从本地文件系统加载一个class文件   删除classPath中的class文件,可以看到是由当前类加载器加载的，而不是系统类加载器加载的
            如果classPath中有这个class，则由系统类加载器加载的
         */
        loader1.setPath("D:\\study\\jvm\\");

        Class<?> clazz = loader1.loadClass("com.kevin.study.jvm.classloader.MyTest1");
        System.out.println("class : " + clazz.hashCode());
        Object instance = clazz.newInstance();  //创建类的实例
        System.out.println(instance);

        System.out.println("----------------");

        //模拟类的卸载 -XX:+TraceClassUnloading
//        loader1 = null;
//        clazz = null;
//        instance = null;
//        System.gc();

        loader1 = new MyTest16("loader1");
        loader1.setPath("D:\\study\\jvm\\");

        clazz = loader1.loadClass("com.kevin.study.jvm.classloader.MyTest1");
        System.out.println("class : " + clazz.hashCode());
        instance = clazz.newInstance();  //创建类的实例
        System.out.println(instance);

        System.out.println("----------------");

//        MyTest16 loader2 = new MyTest16(loader1,"loader2");
//        loader2.setPath("D:\\study\\jvm\\");
//        Class<?> clazz2 = loader2.loadClass("com.kevin.study.jvm.classloader.MyTest1");
//        //如果从classPath中加载的，结果与上面结果一致   系统类加载器只被加载了一次，所以第二次直接使用
//        //从classPath中删除后，得到的结果将不一致
//        System.out.println("class : " + clazz2.hashCode());
//        Object instance2 = clazz2.newInstance();
//        System.out.println(instance2);
//
//        System.out.println("-----------------");
//        MyTest16 loader3 = new MyTest16(loader2 , "loader3");
//        loader3.setPath("D:\\study\\jvm\\");
//        Class<?> clazz3 = loader3.loadClass("com.kevin.study.jvm.classloader.MyTest1");
//        //如果从classPath中加载的，结果与上面结果一致   系统类加载器只被加载了一次，所以第二次直接使用
//        //从classPath中删除后，得到的结果将不一致
//        System.out.println("class : " + clazz3.hashCode());
//        Object instance3 = clazz3.newInstance();
//        System.out.println(instance3);

    }

}