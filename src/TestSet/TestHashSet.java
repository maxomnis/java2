package TestSet;

import java.util.HashSet;

/**
 * HasetSet是set接口的典型实现，大多数时候使用set集合时就是使用这个实现类。‘
 * HashSet按Hash算法类存储集合中的元素,因此具有很好的存取和查找性能
 *
 * hashset有以下特点：
 * 1. 不能保证元素的排列顺序，顺序可能与添加的顺序不同，顺序也有可能发生变化
 * 2. hashset不是同步的，如果多个线程同步访问hashset，假设两个或者两个以上的线程同时
 * 修改hashset集合时，则必须通过代码来保证同步
 * 3. 集合元素值可以是null
 *
 *
 * 当向HashSet集合中存入一个元素时，HashSet调用该对象的hashcode方法得到该对的hashcode值，然后根据该hashcode值决定存
 * 在hashset中的存储位置。如果两个元素的equals()方法比较返回true,但他们的hashcode不同，则会存在不同的位置。这就与
 * set集合的规则冲突了（set的原则是无序，不能重复）
 *
 * 如果把一个对象存入HashSet中，如果需要重写这个类的equals方法，则应该重写其hashcode()方法，
 * 规则是，如果两个对象通过equals方法比较返回true,则这个两个对象的hascode值也应该相同。
 *
 * 如果两个对象的hashcode相同，而equals()不同，则hashset会将它们存在同一个位置，这个位置会用链式结构来存储多个对象，
 *
 */

class A
{
    public boolean equals(Object obj)
    {
        return true;
    }

    public void say()
    {
        System.out.println("in A");
    }
}

class B
{
    public int hashCode()
    {
        return 1;
    }
    public void say()
    {
        System.out.println("in C");
    }
}

class C
{
    public int hashCode()
    {
        System.out.println("调用C的 hashcode");
        return 2;
    }

    public boolean equals(Object obj)
    {
        System.out.println("调用C的 equals");
        return true;
    }

    public void say()
    {
        System.out.println("in C");
    }


}


public class TestHashSet {

    public static void  main(String[] args)
    {
        HashSet books = new HashSet();
        books.add(new A());
        books.add(new A());
        books.add(new B());
        books.add(new B());
        books.add(new C());
        books.add(new C());

        System.out.println(books);
    }
}
