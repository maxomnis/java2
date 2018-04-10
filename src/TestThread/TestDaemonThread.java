package TestThread;

/**
 * 后台线程或者叫守护线程
 * 后台线程有个特征是，如果前台线程都死亡了，后台线程就自动死亡
 */
public class TestDaemonThread extends  Thread{

    public void run()
    {
        for(int i=0; i<1000; i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }


    public static void main(String[] args) throws Exception
    {
        TestDaemonThread t = new TestDaemonThread();
        //将此线程设置为后台线程
        t.setDaemon(true);
        t.setName("守护线程");
        //启动后台线程
        t.start();

        for(int i=0; i<10; i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }

        //调用sleep，让线程暂停1s,守护线程执行到1000才结束
        //Thread.sleep(1000);


        /*
         执行到此处，前台线程main结束，“守护线程”还没执行到1000就结束了
         */
    }
}
