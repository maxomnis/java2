package TestList;

import java.util.List;
import java.util.ArrayList;

/**
 * List集合代表一个元素有序，可重复的集合，集合中每个元素都有其对应的顺序索引。
 * List运行重复元素，可以通过索引来访问指定位置的元素。
 */
public class TestList {

    public static void main(String[] args)
    {
        List books = new ArrayList();

        books.add(new String("轻量级java ee企业级"));
        books.add(new String("疯狂java"));
        books.add(new String("疯狂安卓"));

        //将新字符串加到第二个位置
        books.add(1, new String("疯狂ajax讲义"));

        for(int i=0; i<books.size(); i++)
        {
            System.out.println(books.get(i));
        }

        books.remove(2);
        System.out.println(books);

        //虽然这里是用的String,但是List判断两个对象是否相等用的是equals()方法比较即可
        System.out.println(books.indexOf(new String("疯狂安卓")));
    }
}
