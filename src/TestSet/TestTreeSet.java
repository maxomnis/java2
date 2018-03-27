package TestSet;

import java.util.TreeSet;

/**
 * TreeSet是SortedSet接口的实现类，TreeSet可以确保集合元素处于排序状态
 *
 * 与HashSet集合采用hash算法决定元素的位置不同，TreeSet采用红黑树的数据结构
 * 来存储集合元素
 *
 * TreeSet进行排序的规则，自然排序和定制排序
 * 1. 自然排序
 * java 会调用集合元素的compareTo(Object obj)方法来比较元素之间的大小关系，然后将集合元素按升序排列，这种就是自然排序
 * 当把一个对象加入TreeSet集合时，TreeSet调用该对象的compareTo(Object obj)方法，与容器中的其他对象比较大小，然后根据
 * 红黑树的结构找到他的存储位置，如果两个对象通过compareTo方法比较相等，新对象将无法添加到TreeSet集合中。
 *
 * java提供了一个Comparable接口，该接口定义了compareTo方法，该方法返回一个整数值，当一个对象调用该方法与另一个对象进行
 * 比较时，obj1.compareTo(obj2)，如果该方法返回0，则表明这来给你个对象相等；如果该方法返回一个正整数，则表明obj1大于obj2.
 * 如果该方法返回一个负整数，则表明obj1小于obj2
 */
public class TestTreeSet {

    public static void main(String[] args)
    {
        TreeSet nums = new TreeSet();

        //向TreeSet添加四个Integer对象
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);

        //输出集合元素，
        System.out.println(nums);

        System.out.println(nums.first());  //输出-9

        System.out.println(nums.last());

        //输出小于4的子集，不包含4
        System.out.println(nums.headSet(4));  //输出-9,2

        //返回大于5的子集，如果Set中包含5，子集中还包含5
        System.out.println(nums.tailSet(5));

        //返回大于-3，小于4的子集
        System.out.println(nums.subSet(-3, 4)); //输出2
    }
}
