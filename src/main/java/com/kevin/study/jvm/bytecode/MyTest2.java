package com.kevin.study.jvm.bytecode;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 11:53 2020/8/10
 * @ProjectName: jvm_lecture
 */
public class MyTest2 {

    String str = "welcome";

    private int x = 5;

    public static Integer in = 10;

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        myTest2.setX(8);
        in = 20;
    }

    public void setX(int x) {
        this.x = x;
    }
}
