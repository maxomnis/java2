package TestSet;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * 实现Comparable用于在添加TreeSet的时候进行比较,TreeSet在添加对象时，会调用
 * 该对象的compareTo方法进行比较，如果set里面已存在该值，则添加失败
 */
class  Z implements  Comparable
{
    int age;
    public Z(int age)
    {
        this.age = age;
    }

    //覆盖compareTo方法，始终返回1，让两个对象不想等
    public int compareTo(Object o) {
        return 1;
    }

    public boolean equals(Object obj) {
        System.out.println("equals");
        return true;
    }
}
public class TestTreeSet2 {

    public static void main(String[] args)
    {
        TreeSet set = new TreeSet();
        Z z1 = new Z(6);

        set.add(z1);

        //第二次添加同一个对象，输出true，表明添加成功
        System.out.println(set.add(z1));

        //下面输出set集合，将看到有两个元素
        System.out.println(set);

        //修改set集合，第一个元素的age变量
        ((Z)set.first()).age = 9;

        //输出set集合最后一个元素的age变量，将看到也变成了9;奇怪这是为什么？
        //因为实际上，两次add的是同一个对象z1, set集合里保存的是指向元素的引用，
        System.out.println(((Z)set.last()).age);


    }
}
