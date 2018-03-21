package autoBoxing;

/**
 * java的8种类型，都对应一种包装类
 */
public class TestAutoBoxing {

    public static void main(String[] args)
    {
        //直接把基本类型赋值给Integer,这就是自动装箱
        Integer inObj = 5;

        //直接把boolean类型变量赋给一个Object类型的变量
        Object boolObj = true;

        //直接把Integer对象赋给int类型变量, 自动拆箱
        int it = inObj;

        if(boolObj instanceof Boolean)
        {
            boolean b = (Boolean)boolObj;
            System.out.println(b);
        }



        String intStr = "123";

        //把一个特定字符串转化成Int变量
        int it1 = Integer.parseInt(intStr);
        int it2 = new Integer(intStr);

        String floatStr = "4.56";

        //把一个特定字符串转化成float
        float ft1 = Float.parseFloat(floatStr);
        float ft2 =  new Float(floatStr);

        Integer ina = 2;
        Integer inb = 2;
        System.out.println("两个2自动装箱后是否相等:"+(ina == inb));

        //不相等，Integer会缓存，-128到127的数，放在缓存（就是一个array），所以如果是这个范围之类，比较的话，其实比较的是
        //数组的地址，而超过这个数，则申请的是新的Integer对象，所以128不相等，看Interger源码里面有写
        Integer biga = 128;
        Integer bigb = 128;
        System.out.println("两个128自动装箱后是否相等:"+(biga == bigb));

        System.out.println("两个128自动装箱后是否相等:"+(biga.equals(bigb)));

        System.out.println(Integer.MAX_VALUE);
    }
}
