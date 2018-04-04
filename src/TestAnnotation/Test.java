package TestAnnotation;
import java.util.List;
import java.util.ArrayList;

/**
 * 各种注解的使用
 */
class Fruit {
    public void info()
    {
        System.out.println("水果的Info方法.....");
    }
}

class  Apple extends Fruit
{
    //使用ovveride指定下面的方法必须重写父类方法
    @Override
    public void info()
    {
        System.out.println("apple重写父类的info方法");
    }

    //用于表示某个元素（类，方法已过时），当其他程序使用已过时的类，方法时编译器会给出警告。
    @Deprecated
    public void color()
    {
        System.out.println("apple的color方法.....");
    }


}

//@FunctionalInterface 如果接口只有一个抽象方法，该接口就是函数式接口。@FunctionalInterface就是用来指定某个接口必须是
//函数式接口。 @FunctionalInterface只能修饰接口，不能修饰其他程序元素
@FunctionalInterface
interface FunInterface
{
    static void foo()
    {
        System.out.println("foo类方法");
    }

    static void bar()
    {
        System.out.println("bar类方法");
    }

     void test();  //只定义了一个抽象方法
}


/**
 * @SuppressWarnings指示被该Annotation修饰的程序元素（以及该程序元素中的所有子元素）取消显示指定的
 * 编译器警告。@SuppressWarnings会一直操作用于该程序元素的所有子元素。
 */
@SuppressWarnings(value="unchecked")
public class Test {

    public static void main(String[] args)
    {
        Apple test = new Apple();
        test.color();

        List<String> myList = new ArrayList();
    }
}
