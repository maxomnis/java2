public class TestString {

    public static void main(String[] args)
    {
/*
        String greeting = "hello world";

        char[] helloArray = {'h','e','l','l','o'};
        String helloString = new String(helloArray);
        System.out.println(helloString);
*/

        String a = "jack";
        String b = "jack";
        String c = new String("jack");

        String d = "bbbb";
        //Integer a = Integer.valueOf(100);

        System.out.println(a==b);  //返回true, 注意java”常量池“的概念,
        System.out.println(a==c);

        String name= "jack";
        StringBuffer name1 = new StringBuffer("jack");  //线程安全的，看源码,因为那些append,replace都加了synchronized修饰符
        StringBuilder name2 = new StringBuilder("jack"); //非安全的，没有synchronized修饰符
    }
}
