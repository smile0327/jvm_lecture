package com.kevin.study.jvm.classloader;

/**
 * @Auther: kevin
 * @Description:
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 14:53 2020/7/22
 * @ProjectName: jvm_lecture
 */
public class MyTest15 {

    public static void main(String[] args) {
        /*
            数组类的类加载器是由JVM在运行期动态生成的，动态生成的类型其父类就是Object。
            如果是原生类型（int,double,float等），这个数据类是没有类加载器的。
            数组类的类加载器与元素类的类加载器相同。
         */
        // String类位于rt包中，是由根类加载器加载的，但是根类加载器显示为null
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("--------------");

        //自定义的类是由**应用类加载器**加载的
        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());

        System.out.println("-----------");
        //原生类型，没有类加载器，与第一个例子输出的null是有区别的。
        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());

    }

}
