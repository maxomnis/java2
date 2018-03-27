package TestSet;

/**
 * 测试下Collectiond的使用
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestCollection {

    public static void main(String[] args)
    {
        Collection c = new ArrayList();

        //添加元素
        c.add("孙悟空");
        c.add("孙悟空");

        //虽然集合里不能放基本类型的值，但java支持自动装箱
        c.add(6);
        System.out.println("c集合的元素个数为"+c.size());

        //删除指定元素
        c.remove(6);
        System.out.println("c集合的元素个数为"+c.size());

        System.out.println("c集合是否包含\"孙悟空\"字符串"+c.contains("孙悟空"));

        c.add("javaee企业级开发");
        System.out.println("c集合的元素个数为"+c.size());

        System.out.println("c集合的元素"+c);

        Collection books = new HashSet();
        books.add("javaee企业级开发");
        books.add("java讲义");
        System.out.println("c集合是否包含books集合？"+c.containsAll(books)); //返回flase

        //用c集合减去books集合里的元素
        c.removeAll(books);
        System.out.println("c集合的元素"+c);

        //删除c集合里的所有元素
        c.clear();
        System.out.println("c集合的剩下元素"+c);

        //控制books集合里只剩下c集合里包含的元素
        books.retainAll(c);

        System.out.println("book集合的元素"+books);
    }
}
