package com.company;

/**
 * Created by jack on 2015/4/26.
 */
class TryInitialization {

    static int[] values = new int[10];


    /*
        初始化代码块指位于两个花括号之间的一段代码，他们在创建对象之前执行, 有两种类型的初始化代码；第一种下面的静态初始化

        1. 静态初始化使用关键字static定义的块,并且当类加载时执行一次，静态初始化代码块只能初始化类的静态数据成员;
        2. 非静态初始化代码块对于每个创建的对象都执行，所以能够初始化类中的实例变量
     */
    static {   //删除static关键字，就变成非静态初始化了,然后每次生成的初始化的values就不一样了
        /*

         */
        System.out.println("running initialization block");

        for (int i = 0; i < values.length; i++) {
            values[i] = (int) (100.0 * Math.random());
        }
    }


    void listValues() {
        System.out.println();
        for (int value : values) {
            System.out.print(" " + value);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        TryInitialization example = new TryInitialization();
        System.out.println("\n First object:");
        example.listValues();


        example = new TryInitialization();
        System.out.println("\n Second object:");
        example.listValues();            //由于values是静态化的变量，所以是每个实例共享的，所以这里的输出跟上面的输出是一样的
    }

}
