package TestSet;

import java.util.HashMap;
import java.util.TreeSet;

class  R2 implements Comparable
{
    int count;

    public R2(int count)
    {
        this.count = count;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
        {
            return true;
        }

        if(obj != null && obj.getClass() == R2.class)
        {
            R2 r = (R2)obj;
            return r.count == this.count;
        }
        System.out.println("调用equals...");
        return  false;
    }

    @Override
    public String toString() {
        return "R[count:]"+this.count+"]";
    }


    //重写compareTo方法，根据count比较大小
    @Override
    public int compareTo(Object obj) {
        R2 r = (R2)obj;
        System.out.println("count="+count+", r.count="+r.count);
        return count > r.count ?1:count<r.count?-1:0;
    }
}
public class TestTreeSet3 {
    public static void main(String[] args)
    {
        TreeSet ts = new TreeSet();


        System.out.println(ts.add(new R2(-3)));
        System.out.println(ts.add(new R2(5)));

        System.out.println(ts.add(new R2(9)));
        System.out.println(ts.add(new R2(5)));

        /*
        //打印treeset集合，集合元素是有序排列的
        System.out.println(ts);

        //取出第一个元素
        R2 first = (R2)ts.first();

        //对第一个元素赋值
        first.count = 20;

        //取出最后一个元素
        R2 last = (R2)ts.last();

        //对最后一个元素的count赋值，与第二个元素的count相同
        last.count = -2;

        //再次输出将看到TreeSet里的元素处于无序状态，且有重复元素
        System.out.println(ts);

        System.out.println(ts.add(new R2(-2)));
        System.out.println(ts);
        //删除实例变量被改变的元素，删除失败
      *//*  System.out.println(ts.remove(new R2(-2)));
        System.out.println(ts);*//*

        //删除实例变量没有被改变的元素，删除成功
        System.out.println(ts.remove(new R2(5)));
        System.out.println(ts);*/
    }
}
