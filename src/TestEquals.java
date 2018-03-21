/**
 * 常量池(constant pool)
 * 常量池专门用于管理在编译时被确定并保存在已编译的.class文件中的一些数据，包括了类，接口，方法中的常量，还包括字符串常量
 *
 * JVM常量池保证相同的字符串只有一个，不会产生多个副本。例子中的s1,s4,s5所引用的字符串可以在编译器就确定下来，因此他们
 * 将引用常量池中的一个字符串对象。
 * 使用new string(）创建的字符串是运行时创建的，它被保存在运行时内存去（堆内存），不会放入常量池中
 */
public class TestEquals {

    public static void main(String[] args)
    {
        //s1直接饮用常量池中的“疯狂java"
        String s1 = "疯狂Java";
        String s2 = "疯狂";
        String s3 = "Java";

        //s4后面的字符串值可以在编译时就确定下来
        //s4直接引用常量池中的”疯狂的java“
        String s4 = "疯狂"+"Java";

        //s5后面的字符串值可以在编译时就确定下来
        //s5直接引用常量池中的”疯狂的java“
        String s5 = "疯"+"狂"+"Java";

        /*
          s6后面的字符串值不能在编译时就确定下来
          不能引用常量池中的字符串
         */
        String s6 = s2+s3;

        /*
         使用new构造器创建一个新的String对象
         s7引用堆内存中新建的Sting对象
         */
        String s7 = new String("疯狂Java");

        System.out.println(s1 == s4);   //true
        System.out.println(s1 == s5);   //true

        System.out.println(s1 == s6);  //false
        System.out.println(s1.equals(s6)); //true, equals比较的是值是否相当
        System.out.println(s1 == s7);  //false
    }



}
