package TestGeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * 不管为泛型的类型形参传入哪一种类型参数，对于java来说，它们依然被当成一个类处理，在内存中也只占用一块内存空间，因此
 * 在静态方法，静态初始化块或静态变量声明和初始化中不允许使用类型形参。
 */
public class TestGeneric2 {

    public static void main(String[] args)
    {

        //分别创建
        List<String> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        //这里返回true，
        System.out.println(a1.getClass() == a2.getClass());


    }
}

class R<T>
{
    //下面错误代码，不能在静态变量声明中使用类型形参
    //static  T info;
    T age;
    public void foo(T msg) {}

    //下面代码错误，不能在静态方法中使用类型形参
    //public static void bar(T msg);
}
