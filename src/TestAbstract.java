abstract class Empoyee
{
    private String name;
    private String address;
    private int number;

    /*
     声明抽象方法会造成以下两个结果：
如果一个类包含抽象方法，那么该类必须是抽象类。
任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
继承抽象方法的子类必须重写该方法。否则，该子类也必须声明为抽象类。最终，必须有子类实现该抽象方法，否则，从最初的父类到最终的子类都不能用来实例化对象。
     */
    public abstract double computePay(); //声明抽象方法，


    /*
    抽象类可以包含已经被实现的方法
     */
    public void say()
    {
        System.out.println("hello");
    }
}

public class TestAbstract extends Empoyee{
    public double computePay()
    {
        return 3.2;
    }

    public static void main(String[] args)
    {
        TestAbstract test = new TestAbstract();

        test.say();

        System.out.println(test.computePay());
    }
}
