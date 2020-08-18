package com.kevin.study.jvm.bytecode;

/**
 * @Auther: kevin
 * @Description:
 *
 *  方法的动态分派
 *  方法的动态分派涉及到一个重要概念：方法接收者。
 *  invokevirtual 字节码指令的多态查找流程。
 *  比较方法重载（overload）与方法重写（overwrite），可以得出一个结论：
 *  方法重载是静态的，是编译期行为；方法重写是动态的，是运行期行为。
 *
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 15:06 2020/8/13
 * @ProjectName: jvm_lecture
 */
public class MyTest6 {

    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }

}

class Fruit{
    public void test(){
        System.out.println("Fruit");
    }
}

class Apple extends Fruit{
    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit{
    @Override
    public void test() {
        System.out.println("Orange");
    }
}