package classandobject;

/**
 * final关键字的使用
 * 当使用final修饰基本数据类型时，不能对基本类型变量重新赋值，因此基本类型变量不能被改变。
 * 但对于引用类型变量而言，它保存的仅仅是一个引用，final只保证这个引用类型变量所引用的地址
 * 一直不会改变，即一直引用同一个对象，但这个对象完全可以发生改变
 */

import java.util.Arrays;

class  Person
{
    private  int age;
    public  Person() {}
    public Person(int age)
    {
        this.age = age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return this.age;
    }

    /**
     * private修饰在只能在当前类可见，所以下面的TestFinal继承的时候，是继承不了的，所以在TestFinal再定一个test方法，
     * 不是重载,相当于重新定义了一个方法
     */
    private  final void test(){};
}


public class TestFinal extends  Person{
    public static void main(String[] args)
    {
        final  int a=10;

        final int b;
        b = 200;
        //b = 400;  //非法，b已经初始化了一次
        System.out.println(a);
        //final修饰数组变量，iArr是一个引用变量
        final  int[] iArr = {5, 6, 12, 9};
        System.out.println(Arrays.toString(iArr));

        Arrays.sort(iArr); //合法
        System.out.println(Arrays.toString(iArr));

        iArr[2] = -8;   //合法
        System.out.println(Arrays.toString(iArr));

       // iArr = null;  //非法，改变了iArr的值

        final Person p = new Person(45);
        p.setAge(10);  //合法
        System.out.println(p.getAge());
        //p = null;  //非法操作，改变了P的值



        //可执行宏替换的final变量
        /**
         * final修饰符的一个重要的用途就是定义”宏变量“，当定义final变量时就为该变量指定了初始值，而且该初始值可以在编译
         * 时就确定下来，那么这个final变量本质上就是一个”宏变量“，编译器会把程序中所有用到该变量的地方直接替换成该
         * 变量的值
         */
        final int c = 5;
        System.out.println(c); //javac编译之后，其实已经变成了System.out.println(5)

    }

    public void test(){};
}
