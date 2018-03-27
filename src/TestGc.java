/**
 * 在对象引用次数为0时，对象可能会被回收，对象在被回收之前，vm总会调用它的finalize()方法
 *
 * jdk9已经废除finalize这个方法了，
 */
public class TestGc {

    public static void main(String[] args)
    {
        for(int i=0; i<4; i++)
        {
            new TestGc();
            Runtime.getRuntime().gc(); //强制启用垃圾回收期，
        }
    }


    @Override
    public void finalize()
    {
        Object a =null;
        System.out.println(a);
        System.out.println("系统正在清理TestGc对象");
    }
}
