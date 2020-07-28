package com.kevin.study.jvm.classloader;


/**
 * @Auther: kevin
 * @Description:
 *
 *  助记符：
 *  anewarray：表示创建一个引用类型（如类、接口、数组）的数组，并将其引用值压入栈顶
 *  newarray：表示创建一个指定的原始类型（如int、float、char等）的数组，并将其引用值压入栈顶
 *
 * @Company: 上海博般数据技术有限公司
 * @Version: 1.0.0
 * @Date: Created in 8:17 2019/8/14
 * @ProjectName: jvm_lecture
 */
public class MyTest4 {

    public static void main(String[] args) {
        //1、创建对象实例 “首次主动使用”时初始化  所以会打印静态块中语句
//        MyParent4 myParent4 = new MyParent4();

        /*
            2、对于数组实例来说，其类型是由JVM在运行期动态生成的，表示为 [Lcom.kevin.study.jvm.classloader.MyParent4 这中形式，
                动态生成的类型，其父类型就是Object 。如果元素类型是原生类型（基本类型），那么这个数组类是没有类加载器的。

                对于数组来说，JavaDoc经常将构成数组的元素定义为Component（组件），实际上就是将数组降低一个维度后的类型。
         */
        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());

        MyParent4[][] myParent4s1 = new MyParent4[1][];
        System.out.println(myParent4s1.getClass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());

        short[] shorts = new short[1];
        System.out.println(shorts.getClass());

        char[] chars = new char[1];
        System.out.println(chars.getClass());

        float[] floats = new float[1];
        System.out.println(floats.getClass());

        double[] doubles = new double[1];
        System.out.println(doubles.getClass());

        long[] longs = new long[1];
        System.out.println(longs.getClass());

        boolean[] booleans = new boolean[1];
        System.out.println(booleans.getClass());

        String[] strings = new String[1];
        System.out.println(strings.getClass());
        System.out.println(strings.getClass().getClassLoader());

    }

}


class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}