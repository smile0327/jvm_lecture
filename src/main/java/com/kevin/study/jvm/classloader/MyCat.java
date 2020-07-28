package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 14:05 2020/7/27
 * @ProjectName: jvm_lecture
 */
public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loaded by : " + this.getClass().getClassLoader());

//        System.out.println("from MyCat:" + MySample.class);
    }
}
