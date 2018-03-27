package TestSet;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * HashSet有另外一个子类LinkedHashSet,也是根据元素的hashCode值来决定元素的存储位置。
 * 但它同时使用链表维护元素的次序，这样使得元素看起来是以插入的顺序保存的。也就是说
 * 遍历LinkedHahset集合里的元素时，LinkedHashSet将会按照元素添加的顺序来访问
 *
 * LinkedHashSet需要维护元素的插入顺序，因此性能略低于Hashset的性能，但是迭代访问Set里的
 * 元素时性能很好，因为它以链表来维护顺序
 *
 *
 */

public class TestLinkedHashSet {

    //从下面的输出可以看到，输出的顺序跟添加的顺序意义
  /*
  public static void main(String[] args)
    {
        LinkedHashSet books = new LinkedHashSet();
        books.add("hello");
        books.add("world");
        System.out.println(books);

        books.remove("hello");
        books.add("china");
        System.out.println(books);
    }
*/

    //从下面的输出可以看出，输出顺序跟添加顺序不一样
    public static void main(String[] args)
    {
        HashSet books = new HashSet();
        books.add("hello");
        books.add("world");
        System.out.println(books);

        books.remove("hello");
        books.add("china");
        System.out.println(books);
    }

}
