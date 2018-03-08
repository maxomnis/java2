package com.company;

/**
 * Created by jack on 2015/3/30.
 */

/*
  == 比较的是两边的变量引用的是否是同一个内存地址
  String.equals比较的是两个变量的值是字面量是否相等
 */
public class TestString {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(String.valueOf(3.1415923));


        /*
         "=="不是比较的内存地址吗？为什么这里的str1,str2会相等呢？这就是Java的特性，
         如果是用同一个字面量（比如这里的hello）来初始化，那么只会创建一个String对象，而这两个变量都会引用它,
         所有这里的str1,str2引用的是同一个变量
          */
        if (str1 == str2) {
            System.out.println("str1==str2 is true");
        } else {
            System.out.println("str1==str2 is false");
        }


        String str3 = "hello";
        String str4 = "world";
        String str5 = "helloworld";
        String str6 = str3 + str4;
        System.out.println("str6:" + str6);
        System.out.println("str5:" + str5);

        // str6=str6.intern();   字符串留存  可以使字面量相同的字符串，引用的是同一个引用，所以这里的str5==str6才会相等
        if (str5.equals(str6)) {   //相等，因为他们的字面量相等
            //if(str5==str6){   //不相等,因为引用的不是同一个变量
            System.out.println("str5==str6 is true");
        } else {
            System.out.println("str5==str6 is false");
        }

        String text = "to be or not to be ";
        byte[] textArray = text.getBytes();  //将字符串转换为单个字符对应的ascii值

        for (byte ch : textArray) {
            System.out.println(ch);
        }


        String test = "ssssssss";
        test = "pppppppppp";
        System.out.println(test);

        StringBuffer aString = new StringBuffer("time");
        int theLength = aString.length();
        System.out.println("length is " + theLength);


        StringBuffer sentence = new StringBuffer(10);  //初始化sentence的容量为10
        sentence.append("ffffff");
        System.out.println("capacity is " + sentence.capacity() + " length is " + sentence.length());  //capacity返回当前sentence的容量

    }
}
