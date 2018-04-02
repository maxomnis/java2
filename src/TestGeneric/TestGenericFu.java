package TestGeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型通配符( ? )使用
 */
public class TestGenericFu {
    //为了表示各种泛型List的父类，可以使用通配符，类型通配符是一个？
    static  void test(List<?> c)
    {
        for(int i=0; i<c.size(); i++)
        {
            System.out.println(c.get(i));
        }
    }

    public static void main(String[] args)
    {
        List<String> hello = new ArrayList<>();
        hello.add("hello");
        hello.add("world");
        test(hello);

        List<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(2);
        number.add(3);
        test(number);

    }
}
