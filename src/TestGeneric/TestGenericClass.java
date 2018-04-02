package TestGeneric;

/**
 * 可以为任何类，接口增加泛型声明（并不是只有集合类才可以使用泛型声明，虽然集合类是泛型的重要使用场所）
 */

//定义一个Apple类使用了泛型声明
class  Apple<T>
{

    private T info;
    public Apple() {}

    //下面方法使用T类型来定义构造器
    public Apple(T info)
    {
        this.info = info;
    }

    public void setInfo(T info)
    {
        this.info = info;
    }

    public T getInfo()
    {
        return this.info;
    }
}


public class TestGenericClass {
    public static void  main(String[] args)
    {
        Apple<String> a1 = new Apple<>("苹果");
        System.out.println(a1.getInfo());

        Apple<Double> a2 = new Apple<>(3.2);
        System.out.println(a2.getInfo());
    }

}
