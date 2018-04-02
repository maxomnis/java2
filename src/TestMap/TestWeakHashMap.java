package TestMap;

import java.util.WeakHashMap;

public class TestWeakHashMap {

    public static void main(String[] args)
    {
        WeakHashMap whm = new WeakHashMap();

        whm.put(new String("语文"), new String("良好"));
        whm.put(new String("数学"), new String("及格"));
        whm.put(new String("英文"), new String("中等"));

        whm.put("java", new String("中等"));

        System.out.println(whm);

        System.gc();
        System.runFinalization();

        System.out.println(whm);
    }

    /**
     * 输出：
     {英文=中等, java=中等, 数学=及格, 语文=良好}
     {java=中等}
     */
}


