package com.kevin.study.jvm.classloader;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 16:22 2020/7/30
 * @ProjectName: jvm_lecture
 */
public class MyTest27 {

    public static void main(String[] args) throws Exception {
        /*
            这里可以不用设置Class.forName("com.mysql.jdbc.Driver")，由于SPI 机制，会自动加载java.sql.Driver的具体实现类;
            DriverManager类中会执行如下方法（SPI机制加载）：ServiceLoader<Driver> loadedDrivers = ServiceLoader.load(Driver.class);
            Reflection.getCallerClass() 获取调用该方法的类
         */
        Class.forName("com.mysql.jdbc.Driver");
        /*
            1、先调用DriverManager的静态方法，通过SPI 的方式加载并初始化所有的Driver，并存在一个集合
            2、从集合中选取一个合适的Driver来与数据库创建连接（已加载的Driver与重新通过binary name加载的class相同）
         */
        Connection connection = DriverManager.getConnection("jdbc:mysql://10.172.246.234:3306/test", "root", "bobandata123");
    }

}
