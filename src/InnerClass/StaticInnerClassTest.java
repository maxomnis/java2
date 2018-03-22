package InnerClass;

/**
 * 如果使用static来修饰一个内部类，则这个内部类属于外部类本身，而不属于外部类的某个对象
 *
 */
public class StaticInnerClassTest {

    private int prop1 = 5;
    private static  int prop2 = 9;

    //静态内部类
    static class StaticInnerClass
    {
        //静态内部类可以包含静态成员,非静态成员
        private static  int age;
        private int prop2 = 44;
        public void accessOuterProp()
        {
            //静态内部代码无法访问外部类的实例变量
            //System.out.println(prop1);
            System.out.println(prop2);
        }
    }

    public void accessInnerProp()
    {
        System.out.println(StaticInnerClass.age);
        System.out.println(new StaticInnerClass().prop2);
    }

    public static void main(String[] args)
    {
        StaticInnerClassTest test = new StaticInnerClassTest();
        test.accessInnerProp();
    }
}
