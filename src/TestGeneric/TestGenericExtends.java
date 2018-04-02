package TestGeneric;
class  Blanan<T>
{

    protected T info;
    public Blanan() {}

    //下面方法使用T类型来定义构造器
    public Blanan(T info)
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

/**
 * 当创建带泛型声明的接口，父类之后，可以为该接口创建实现类，或从该父类派生子类，需要指出的是，当使用这些接口，父类时；
 * 是不能包含类型形参的，例如
 *  public class A extends Blanan<T> { } ;
 *  如果想从Blanan派生一个子类，则可以改为如下代码
 *  public class A extends Blanan<String> {} ; //这里要是个具体的类型
 *
 *  调用方法时必须为所有的数据参数传入参数值，与调用方法不同的是，使用类，接口时也可以不为类型参数传入实际的
 *  类型参数,例如下面的代码也是正确的。
 *  public class A extends Blanan {}
 *
 *  如果从Blanane<Stirng>派生子类，则可以在Blanan类中使用T类型的参数的地方都可以被替换成String类型，即它子类将会继承
 *  String getInfo() ,void setInfo(),如果子类需要覆盖父类的方法，则必须注意这点。
 */

class Test extends Blanan<String>
{
    public Test(String info)
    {
        this.info = info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public String getInfo()
    {
        return "子类"+this.info;
    }
}

class Test2 extends Blanan
{
    public String getInfo()
    {
        return super.getInfo().toString();
    }
}

public class TestGenericExtends
{

    public static void main(String[] args)
    {
        Test test = new Test("hello");
        System.out.println(test.getInfo());

        //System.out.println(new Test2().getInfo());
    }
}



