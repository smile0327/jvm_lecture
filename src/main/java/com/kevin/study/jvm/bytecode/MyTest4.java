package com.kevin.study.jvm.bytecode;

/**
 * @Auther: kevin
 * @Description:
 *  栈帧（stack frame）
 *  栈帧是一种用于帮助虚拟机执行方法调用与方法执行的数据结构。
 *  栈帧本身是一种数据结构，封装了方法的局部变量表、动态链接信息、方法的返回地址以及操作数栈等信息。
 *
 *  符号引用，直接引用
 *  有些符号引用是在类加载阶段或是第一次使用时就会转换为直接引用，这种转换叫做静态解析；另外一些符号引用则是
 *  在每次运行期转换为直接引用，这种转换叫做动态链接，这体现为Java的多态性。
 *
 *
 *  助记符：
 *  1、invokestatic：调用静态方法
 *  2、invokeinterface：调用接口中的方法，实际上是运行期决定的，决定到底调用实现该接口的哪个对象的方法
 *  3、invokespecial：调用自己的私有方法、构造方法以及父类的方法
 *  4、invokevirtual：调用虚方法，运行起动态查找的过程
 *  5、invokedynamic：动态调用方法
 *
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 15:54 2020/8/12
 * @ProjectName: jvm_lecture
 */
public class MyTest4 {

    public static void test(){
        System.out.println("test invoked");
    }

    public static void main(String[] args) {
        test();
    }

}
