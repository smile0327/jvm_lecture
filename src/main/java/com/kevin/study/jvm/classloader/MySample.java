package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 *  关于命名空间：
 *  1、子加载器所加载的类能够访问到父加载器所加载的类
 *  2、父加载器所加载的类无法访问到子加载器所加载的类
 *
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 14:07 2020/7/27
 * @ProjectName: jvm_lecture
 */
public class MySample {

    public MySample() {
        System.out.println("MySample is loaded by : " + this.getClass().getClassLoader());

        new MyCat();

        System.out.println("from MyCat:" + MyCat.class);
    }
}
