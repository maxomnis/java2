package TestList;

import java.util.*;

/**
 * java提供了一个操作Set,list和Map等集合的工具类：Collections；该工具类提供了大量方法对集合元素排序，查询和修改等操作
 * 还提供了将集合对象设置为不可变的，对集合对象实现同步控制等方法
 *
 * Collections提供了多种syncronizedXXX()方法，该方法可以将指定集合包装成线程同步集合，从而解决多线程的访问的问题；
 *
 * Collections提供了三类方法返回一个不可变的集合
 *
 */
public class TestCollectionsTool {

    public static void  main(String[] args)
    {
        ArrayList nums = new ArrayList();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println(nums);

        //将list集合次序反转
        Collections.reverse(nums);
        System.out.println(nums);

        Collections.sort(nums); //将list集合排序
        System.out.println(nums);

        Collections.shuffle(nums); //将List集合元素按随即顺序排序
        System.out.println(nums);

        System.out.println(Collections.max(nums)); //找出集合最大值

        System.out.println(Collections.min(nums));  //找出集合最小值

        //下面创建了四个线程安全版本的集合对象
        Collection c = Collections.synchronizedCollection(new ArrayList<>());
        List list = Collections.synchronizedList(new ArrayList<>());
        Set s = Collections.synchronizedSet(new HashSet());
        Map m = Collections.synchronizedMap(new HashMap());

        //创建一个空的，不可改变的List对象
        List unmodifiableList = Collections.emptyList();

        //创建一个只有一个元素，且不可改变的Set对象
        Set unmodifiableSet = Collections.singleton("疯狂java讲义");
    }
}
