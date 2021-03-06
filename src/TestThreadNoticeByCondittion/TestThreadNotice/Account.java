package TestThreadNoticeByCondittion.TestThreadNotice;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

/**
 * 使用互斥锁来控制线程
 *
 * 下面的daemo 是为了模拟线程间的通信
 *
 * 假设系统中两个线程，这两个线程分别代表存钱者，取钱者；现在假设系统有一种特殊的要求，
 * 系统要求存钱者和取钱者，不断重复的取钱，存钱的动作；而且要求每当存钱者将钱存入指定
 * 账户后，取钱者立即取出这笔钱；不允许存钱者连续两次存钱，也不允许取钱者连续两次取钱
 */
public class Account {

    //定义lock对象
    private final Lock lock = new ReentrantLock();

    //获取指定Lock对象的Condition
    private final Condition cond = lock.newCondition();

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    //封装账户编号，余额
    private String accountNo;
    private double balance;

    //标记账户中是否已有存款的标志
    private boolean flag = false;

    public Account() {}

    public Account(String accountNo, double balance)
    {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    //因为账户余额不允许随便修改，所以只为lalance提高工get方法
    private double getBalance()
    {
        return this.balance;
    }

    /**
     * 取钱操作
     * @param drawAmount
     */
    public  void draw(double drawAmount)
    {
        //加锁
        lock.lock();

        try
        {


            //如果flag为假，表明账户中还没有人存钱进去，取钱方法阻塞
            if(!flag)
            {
                cond.await(); //阻塞
            }else
            {
                //执行取钱操作
                System.out.println(Thread.currentThread().getName()+"取钱"+drawAmount);
                this.balance -= drawAmount;

                //System.out.println("账户余额为:"+this.balance);

                //将标示账户是否已有存款的标志设置为false
                flag = false;

                //唤醒其他线程
                cond.signalAll();

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            //System.out.println("取钱 unlock");
            lock.unlock();
        }
    }

    /**
     * 存钱操作
     * @param depositAmount
     */
    public  void deposit(double depositAmount)
    {
        //加锁
        lock.lock();

        try
        {


            //如果flag为真，表明账户已有人存入钱，存钱放阻塞
            if(flag)
            {
                //System.out.println("已经有人存过钱");
                cond.await();
            }else
            {
                //执行存款操作
                System.out.println(Thread.currentThread().getName()+"存款："+depositAmount);
                balance += depositAmount;
                //System.out.println("账户余额为:"+this.balance);

                //将标示账户是否已经存款的标志设置为true
                flag = true;

                //唤醒其他线程
                cond.signalAll();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            //System.out.println("存钱unlock");
            lock.unlock();
        }
    }

}
