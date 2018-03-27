package TestMap;

import java.util.Hashtable;

/**
 * 为了在HashMap, Hashtable中存储，获取对象，用作key的对象必须实现hashCode()， equals()方法
 */

class  A
{
    int count;
    public A(int count)
    {
        this.count = count;
    }

    public boolean equals(Object obj)
    {
        if(obj == this)
        {
            return true;
        }

        if(obj != null && obj.getClass() == A.class)
        {
            A a = (A)obj;
            return this.count == a.count;
        }

        return false;
    }

    //根据count来计算haschCode值
    public int hashCode()
    {
        return this.count;
    }
}

class  B
{
    //重写euqlas方法，B对象与任何通过equals方法比较都返回true
    public boolean equals()
    {
        System.out.println("in B.equals()....");
        return true;
    }
}

public class TestHashTable {

    public static  void main(String[] args)
    {
        Hashtable ht = new Hashtable();
        ht.put(new A(1232), "ffff");
        ht.put(new A(60000), "疯狂java讲义");
        ht.put(new A(87563), "轻量级javaee企业应用实战");

        System.out.println(ht);
        System.out.println(ht.containsValue("测试字符串"));

        System.out.println(ht.containsKey(new A(87563)));
        System.out.println(ht.containsValue(new B()));

    }
}
