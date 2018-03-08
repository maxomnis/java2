package generics;
/*
有界的类型参数:
可能有时候，你会想限制那些被允许传递到一个类型参数的类型种类范围。例如，一个操作数字的方法可能只希望接受Number或者Number子类的实例。这就是有界类型参数的目的。
要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。
实例

下面的例子演示了"extends"如何使用在一般意义上的意思"extends"（类）或者"implements"（接口）。该例子中的泛型方法返回三个可比较对象的最大值。
*/

public class TestGenericsMaxValue {

    public static <T extends Comparable<T>> T maxinum(T x , T y, T z)
    {
        T max = x;
        if(y.compareTo(max) > 0)
        {
            max = y;
        }

        if(z.compareTo(max)>0)
        {
            max = z;
        }
        return max;
    }


    public static void main(String[] args)
    {
        int a = 10;

        System.out.printf("max of %d, %d and %d is %d\n\n", 3,4,5, maxinum(3,4,5));

        System.out.printf("max of %s,%s and %s is %s\n","pear", "apple", "orange", maxinum("pear", "appple", "orange"));
    }
}



