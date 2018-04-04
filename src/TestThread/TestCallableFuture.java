package TestThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Callable,FetureTask实现多线程
 * 使用Callable接口，FutureTask类来包装call对象，来获取call()方法的返回值，其他两种方式，是获取不到run()方法的返回值的
 */

public class TestCallableFuture {
    public static void main(String[] args)
    {
        //创建Callable对象
        TestCallableFuture rt = new TestCallableFuture();

        //使用lambda表达式创建Callable<Integer>对象
        //使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>)()->{
            int i = 0;
            for(; i<100; i++)
            {
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
            //call方法返回值
            return i;
        });

        for(int i=0; i< 100 ;i++)
        {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);

            if( i == 20)
            {
                //实质还是以Callable对象来创建并启动线程的
                new Thread(task, "有返回值的线程").start();
            }
        }

        try
        {
            //获取线程的返回值
            System.out.println("子线程的返回值"+task.get());
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
