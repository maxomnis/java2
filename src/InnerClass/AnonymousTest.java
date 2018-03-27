package InnerClass;

/**
 * 匿名内部类适合创建那种只需要一次使用的类
 * 语法有点奇怪，创建匿名内部类时会立即创建一个该类的实例，这个类定义立即消失，
 * 匿名内部类不能重复使用
 */
interface Product
{
    public double getPrice();
    public String getName();
}

public class AnonymousTest {

    public void test(Product p)
    {
        System.out.println("购买一个"+p.getName()+",花掉了"+p.getPrice());
    }


    public static void main(String[] args)
    {
        AnonymousTest ta  = new AnonymousTest();

        //这里就是定义了一个匿名的内部类，并且实现了Product的接口
        ta.test(new Product() {
            @Override
            public double getPrice() {
                return 567.8;
            }

            @Override
            public String getName() {
                return "agp显卡";
            }
        });
    }
}
