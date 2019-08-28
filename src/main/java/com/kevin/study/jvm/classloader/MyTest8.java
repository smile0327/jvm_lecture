package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 8:13 2019/8/28
 * @ProjectName: jvm_lecture
 */
public class MyTest8 {

    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }

}


class FinalTest{
    public static final int x = 3;

    static {
        System.out.println("FinalTest static block");
    }

}