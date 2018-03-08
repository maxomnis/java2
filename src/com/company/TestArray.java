package com.company;

import java.util.Arrays;

import static java.util.Arrays.fill;

/**
 * Created by jack on 2015/3/29.
 */
public class TestArray {
    public static void main(String[] args) {

        int primes[]; //声明一个指向int类型数组的占位符
        int primes2[]; //第二种写法

        primes = new int[10];

        System.out.println("primes length is " + primes.length);

        //将primes指向新的数组
        primes = new int[50];
        System.out.println("primes length is " + primes.length);

        int[] data = {2, 3, 4, 5, 610, 1222}; //声明的时候初始化数组

        for (int i = 0; i < data.length; i++) {
            System.out.println("data[" + i + "] is " + data[i]);
        }

        fill(data, 10000);  //初始化数组，以10000初始化数组中的所有数

        for (int i = 0; i < data.length; i++) {
            System.out.println("data[" + i + "] is " + data[i]);
        }

        int prime3[];

        prime3 = primes; //prime3跟primes指向了同一个数据，他们引用的地址一样，其实他们是共享了同一个数据，所以，只要改变其中的一个，另外一个也会改变

        //二维数组
        float[][] temperature;
        temperature = new float[10][365]; //10行,365列

        //创建变长数组
        float[][] samples = new float[6][];

        //由于这里只给了索引是2,5的行初始化了，所以当输出该数组的时候，会报空指针异常
        samples[2] = new float[6];
        samples[5] = new float[101];


     /*   for (int i=0; i<samples.length; i++){
            System.out.println("length is "+samples[i].length);
        }*/

        //多维数组
        long[][][] beans = new long[5][10][20];

        long[][][] bean = new long[3][][];

        bean[0] = new long[4][];
        bean[1] = new long[2][];
        bean[2] = new long[5][];


        System.out.println(String.valueOf(beans));
        System.out.println(String.valueOf(bean));


    }
}


