package InnerClass;

/**
 * 局部内部类
 * 把一个内部类定义在方法里，则这个方法就是局部内部类
 */
public class LocalInnerClass {

    public static void main(String[] args)
    {

        //定义局部内部类
        class InnerBase
        {
            int a;
        }

        //定义局部内部类的子类
        class InnerSub extends InnerBase
        {
            int b;
        }

        InnerSub is = new InnerSub();
        is.a = 5;
        is.b = 8;
        System.out.println("InnerSub对象的a和b的实例变量是"+is.a+','+is.b);
    }
}
