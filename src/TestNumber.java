/*
Java Number类

一般地，当需要使用数字的时候，我们通常使用内置数据类型，如：byte、int、long、double等。
实例

int i = 5000;
float gpa = 13.65;
byte mask = 0xaf;
然而，在实际开发过程中，我们经常会遇到需要使用对象，而不是内置数据类型的情形。为了解决这个问题，Java语言为每一个内置数据类型提供了对应的包装类。
所有的包装类（Integer、Long、Byte、Double、Float、Short）都是抽象类Number的子类。

这种由编译器特别支持的包装称为装箱，所以当内置数据类型被当作对象使用的时候，编译器会把内置类型装箱为包装类。相似的，编译器也可以把一个对象拆箱为内置类型。Number类属于java.lang包。

 */
public class TestNumber {

    public static void main(String[] args)
    {
        Integer x=5;
        Integer y = 10;
        Integer b = 10;
        x = x+10;
        System.out.println(x);
        System.out.println(y.intValue()); //将number对象转换为xxx数据类型的值并返回。

        System.out.println(y.equals(b)); //判断number对象是否与参数相等

        System.out.println(Integer.valueOf(5));  //返回一个Integer对象指定的内置数据类型
        System.out.println(y.toString());   //以字符串形式返回值。

        System.out.println(Integer.parseInt("200"));  //将字符串解析为int类型。
    }
}
