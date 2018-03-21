package classandobject;

/**
 * static关键字修饰的成员变量就是类变量
 */
public class TestStatic {

    //static修饰的是类方法
    private static void test () throws NullPointerException
    {
        System.out.println("static 修饰的类方法");
    }

    private void test2()
    {
        System.out.println("实例成员");
    }

    /**
     * 类方法也是类成员的一种，类方法也属于类的，通常直接使用类作为调用者来调用类方法，但也可以使用对象来调用类方法。
     * 与类变量类似，即使使用对象来调用类方法。其效果也与采用类来调用方法完全一样。
     *
     * 当使用实例来访问类成员时，实际上依然是委托给类来访问类成员，即使某个实例为null，比如下面的，test依然可以调用
     */
    public static void main(String[] args)
    {
        TestStatic nas = null;
        nas.test();
        nas.test2();  //这个会引发空指针异常，因为nas对象为null,所以不存在test2()函数
    }
}
