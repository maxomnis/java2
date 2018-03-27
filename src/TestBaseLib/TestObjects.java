package TestBaseLib;

import java.util.Objects;

/**
 * Objects java7新增的工具类（后面多了个s，非超级父类Object哦）
 *
 * 如果一个null对象调用toString则可能引发NullPointerException异常，但如果使用Objects提供的toString方法，就不会引发空指针
 * 异常，而是返回null
 */
public class TestObjects {
    static TestObjects obj=null;

    public static void main(String[] args)
    {
        System.out.println(Objects.hash(obj));
        System.out.println(Objects.toString(obj));

        //如果obj是空，则会引发异常，输出后面的提示语
        System.out.println(Objects.requireNonNull(obj,"obj参数不能是null"));
    }
}
