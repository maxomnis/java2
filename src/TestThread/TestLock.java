package TestThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用锁来实现，取钱的操作
 * 锁与synchornized的不同点：
 * 1 . 锁比synchronized更灵活，synchronized的释放是自动释放的，锁的释放需要手动的unLock
 * 2. 锁提供了tryLock()方法（获取锁失败，会立刻返回失败，不会阻塞，lock()是阻塞的），提供了可中断的lockInterruptibly()
 * 方法， tryLock(long , timeUnit)超时失效锁
 */
class Account3 {
    /**
     * 下面是定义锁对象, ReentrantLock（可重入锁）
     * 可重入锁的意思是，一个线程可以对已经被加锁的ReentrantLock再次加锁，ReentrantLock对象会维护一个计数器来追踪
     * lock()方法的嵌套调用，线程在每次Lock之后，必须显示的调用unlock释放锁
     */

    private final ReentrantLock lock = new ReentrantLock();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private String name;
    private double amount;

    public Account3(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    //提供一个线程安全的取钱操作
    public void draw(double drawAmount) {

        //加锁
        lock.lock();
        try {
            System.out.println("加锁成功");
            //如果余额大于取钱
            if (this.amount >= drawAmount) {
                System.out.println(getName() + "取钱成功，吐出钞票" + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                this.amount -= drawAmount;
                System.out.println("余额为" + this.amount);
            } else {
                System.out.println("取钱失败,余额不足" + drawAmount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("释放锁");
            lock.unlock();
        }

    }
}

public class TestLock extends Thread {

    private Account3 account2;
    private double drawAmcount;

    public TestLock(String name, Account3 account, double drawAmcount) {
        super(name);
        this.account2 = account;
        this.drawAmcount = drawAmcount;
    }

    public void run() {
        this.account2.draw(this.drawAmcount);
    }

    public static void main(String[] args) {
        Account3 account2 = new Account3("父母的工行卡", 1000);

        new TestLock("老大", account2, 900).start();
        new TestLock("老二", account2, 700).start();
    }
}
