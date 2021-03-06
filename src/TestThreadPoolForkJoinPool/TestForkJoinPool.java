package TestThreadPoolForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的另外一种实现方式
 * 打印0~300之间的数值
 * 利用ForkJoinPool将任务拆分为多个子任务运行， 然后再汇总
 */

//继承RecursiveAction来实现“可分解”的任务
class PrintTask extends RecursiveAction
{

    //每个小任务最多打印50个数
    private  static final int THRESHOLD = 50;
    private  int start;
    private  int end;

    //打印从start到end的任务
    public PrintTask(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     */
    @Override
    protected void compute() {
        //当end与start之间的差小于THRESHOLD时，开始打印
        if(end - start < THRESHOLD)
        {
            for(int i = start; i < end; i++)
            {
                System.out.println(Thread.currentThread().getName()+"的i值:"+i);
            }
        }else
        {
            //当end与start之间的差大于THRESHOLD,即要打印的数超过50个时，将大任务拆分成两个小任务
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);

            left.fork();
            right.fork();
        }
    }
}
public class TestForkJoinPool {

    public static void main(String[] args) throws  Exception
    {

        System.out.println(Runtime.getRuntime().availableProcessors());
        ForkJoinPool pool = new ForkJoinPool(2);

        //提交可分解的PrintTask任务
        pool.submit(new PrintTask(0, 300));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        //关闭线程池
        pool.shutdown();
    }
}
