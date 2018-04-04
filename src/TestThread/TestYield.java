package TestThread;


/**
 * yield()方法，让步线程
 * 在多CPU的环境下,yield的效果并不明显
 */
public class TestYield extends  Thread{
    public TestYield(String name)
    {
        super(name);
    }

    public void run()
    {
        for(int i=0; i<100; i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);

            if(i == 20)
            {
                Thread.yield();
            }
        }
    }


    public static void main(String[] args)
    {
        TestYield yt1 = new TestYield("高级");
        yt1.setPriority(Thread.MAX_PRIORITY);
        yt1.start();

        TestYield yt2 = new TestYield("低级");
        yt2.setPriority(Thread.MIN_PRIORITY);
        yt2.start();
    }


}
