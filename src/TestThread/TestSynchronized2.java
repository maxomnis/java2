package TestThread;

/**
 * Synchronized 同步方法
 * 在方法前面加上Synchronized修饰符
 * <p>
 * 将取钱操作封装在对象里面，更符合面向对象的设计
 */

class Account2 {
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

    public Account2(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    //提供一个线程安全的取钱操作
    public synchronized void draw(double drawAmount) {
        //如果余额大于取钱
        if (this.amount >= drawAmount) {
            System.out.println(Thread.currentThread().getName()+"从"+getName() + "取钱成功，吐出钞票" + drawAmount);
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }

            this.amount -= drawAmount;
            System.out.println(Thread.currentThread().getName()+"从"+getName() +"余额为" + this.amount);
        } else {
            System.out.println(Thread.currentThread().getName()+"从"+getName() +"取钱失败,余额不足" + this.amount);
        }
    }
}


public class TestSynchronized2 extends Thread {
    private Account2 account2;
    private double drawAmcount;

    public TestSynchronized2(String name, Account2 account, double drawAmcount) {
        super(name);
        this.account2 = account;
        this.drawAmcount = drawAmcount;
    }

    public void run() {
        this.account2.draw(this.drawAmcount);
    }

    public static void main(String[] args) {
        Account2 account2 = new Account2("父母的工行卡", 1000);
        new TestSynchronized2("老大", account2, 900).start();

        new TestSynchronized2("老二", account2, 700).start();
    }
}
