package generics;

/*
一个基本的原则是：无论何时，只要你能做到，你就应该尽量使用泛型方法。也就是说，如果使用泛型方法可以取代将整个类泛化，
那么应该有限采用泛型方法。下面来看一个简单的泛型方法的定义

可以看到方法的参数彻底泛化了，这个过程涉及到编译器的类型推导和自动打包，也就说原来需要我们自己对类型进行的判断和处理，
现在编译器帮我们做了。这样在定义方法的时候不必考虑以后到底需要处理哪些类型的参数，大大增加了编程的灵活性。
 */
public class TestGenericesFunction {

    public static <T> void out(T t)
    {
        System.out.println(t);
    }

    public static <T> void out2(T...args)
    {
        for(T t: args)
        {
            System.out.println(t);
        }
    }
    public static void main(String[] args)
    {
        out("friend");
        out(123);
        out(true);
        out(12.11);
        out2(123,1.1, true, 2);
    }
}
