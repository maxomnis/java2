package TestThread;

/**
 * 通过继承Runnable，实现run()接口的方式实现多线程
 */
public class TestRunnable  implements Runnable{
    private int i;
    public void  run()
    {
        for(; i<100; i++)
        {
            /**
             * 当前线程继承thread类时，直接使用this即可获取当前线程
             * thread对象的getName()返回当前线程的名字
             * 因此可以直接调用getName()方法返回当前线程的名字
             */
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

    public static void main(String[] args)
    {
        for(int i=0; i<100; i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);

            if(i == 20)
            {
                TestRunnable st = new TestRunnable();
                new Thread(st, "线程1").start();
                new Thread(st, "线程2").start();
            }
        }
    }
}
