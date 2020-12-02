package test.thead;

/**
 * 通过继承Thread实现多线程
 */
public class FirstThread extends Thread{

    private int i;

    //重写run()方法，run()方法的方法体就是线程的执行体
    public void run()
    {
        for(; i<100; i++)
        {
            /**
             * 当前线程继承thread类时，直接使用this即可获取当前线程
             * thread对象的getName()返回当前线程的名字
             * 因此可以直接调用getName()方法返回当前线程的名字
             */
            System.out.println(getName()+" "+i);
            System.out.println(System.Logger.Level.INFO);
        }
    }

    public static void main(String[] args) throws Exception
    {
        for(int i=0; i< 100; i++)
        {
            //调用Thread的currentThread()方法获取当前线程
            System.out.println(Thread.currentThread().getName()+ " "+i);
            if(i == 20)
            {
                //创建并启动一个新线程
                new FirstThread().start();

                //创建并启动第二个线程
                new FirstThread().start();
                sleep(1);
            }
        }
    }
}
