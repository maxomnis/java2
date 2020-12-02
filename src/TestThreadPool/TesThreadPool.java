package TestThreadPool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池创建
 */
public class TesThreadPool {
    public static void main(String[] args)
    {
        //创建一个固定线程数(6)的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);

        //使用lambda表达式创建Runnable对象
        Runnable target = ()->{
            for(int i =0; i<3; i++)
            {
                System.out.println((new Date())+Thread.currentThread().getName()+"的i值为"+i);
            }
        };

        //向线程池中提交两个线程
        pool.submit(target);
        pool.submit(target);
        pool.submit(target);
        pool.submit(target);
        pool.submit(target);
        pool.submit(target);


        //当不想提交任务时，调用shutdown方法关闭线程池,shutdown会等到线程池中的任务执行完之后，main线程才会退出
        pool.shutdown();
    }
}
