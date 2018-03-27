package TestMap;

import  java.util.HashMap;

public class TestNullInHashMap {

    public static void main(String[] args)
    {
        HashMap hm = new HashMap();

        //试图将两个key为null的值key-value放入HashMap中
        hm.put(null,null);

        //添加失败，因为map中已经存在一个key_value的key为null的值
        hm.put(null,null);

        hm.put("a", null);
        System.out.println(hm);
    }
}
