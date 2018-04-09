package TestConcurrentList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  使用线程安全类ConcurrentHashMap实例
 */
class TestThread extends Thread
{
    private ConcurrentHashMap names;
    private String key;
    private  Integer value;

    public TestThread(String name, ConcurrentHashMap names, String key, Integer value)
    {
        super(name);
        this.names = names;
        this.key = key;
        this.value = value;
    }

    public void run()
    {
        this.names.replace(this.key, this.value);
        System.out.println(this.names.get("age1"));
        //System.out.println();
    }
}

public class TestConcurrentList {
    public static void main(String[] args)
    {
        ConcurrentHashMap names = new ConcurrentHashMap();
        names.put("age1", "10");

        //System.out.println(names.get("age1"));

        new TestThread("线程甲", names, "age1", 200).start();
        new TestThread("线程乙", names, "age1", 600).start();
        new TestThread("线程丙", names, "age1", 900).start();
        //System.out.println(names.get("age1"));
    }


}
