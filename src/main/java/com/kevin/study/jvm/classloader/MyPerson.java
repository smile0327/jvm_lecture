package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 10:15 2020/7/28
 * @ProjectName: jvm_lecture
 */
public class MyPerson {

    private MyPerson myPerson;

    public void setMyPerson(Object object) {
        this.myPerson = (MyPerson) object;
        System.out.println("invoke setMyPerson method");
    }
}
