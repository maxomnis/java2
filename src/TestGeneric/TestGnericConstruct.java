package TestGeneric;

/**
 * 泛型构造器
 */

class Foo
{

/*
    正常格式的构造器
    public Foo(String name)
    {

    }
*/


    public <T> Foo(T t)
    {
        System.out.println(t);
    }

}


public class TestGnericConstruct {

    public static void main(String[] args)
    {
         //泛型构造器中的T参数为String
        new Foo("疯狂java讲义");

        //泛型构造器中的T参数为Integer
        new Foo(200);

        //显示指定泛型构造器中的T参数为String
        //传给Foo构造器的实参也是String对象，完全正确
        new<String> Foo("疯狂安卓讲义");

        //显示指定泛型构造器是double对象，下面代码错误
        //new<String> Foo(12.3);
    }
}
