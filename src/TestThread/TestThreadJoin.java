package TestThread;

/**
 * join 线程
 *  Thread提供了一个线程等待另一个线程完成的方法,join
 */
public class TestThreadJoin extends Thread{

    //提供一个有参数的构造器，用于设置线程的名字
    public TestThreadJoin(String name)
    {
        super(name);
    }

    //重写run方法，定义线程执行体
    public void run()
    {
        for(int i = 0; i<100; i++)
        {
            System.out.println(getName()+" "+i);
        }
    }

    public static void main(String[] args ) throws Exception
    {
        //启动子线程
        new TestThreadJoin("新线程").start();

        for(int i = 0; i<100; i++)
        {
            if(i == 20)
            {
                TestThreadJoin jt = new TestThreadJoin("被join的线程");

                jt.start();

                /**
                 * main线程调用了jt线程的join()方法，main线程必须等待jt执行结束才会向下执行
                 */
                jt.join();

            }
            System.out.println(Thread.currentThread().getName()+ " "+i);
        }
    }
}
