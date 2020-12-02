package test.thead;

/**
 * 同步代码块(这种操作不符合面向对象的设计，)
 * 语法格式
 * synchronized(obj)
 * {
 *     ......
 *     //此处代码就是同步代码块
 * }
 * obj就是同步监视器，上面的代码的意思是：线程开始执行同步代码之前，必须先获得对同步监视器的锁定
 *
 * 任何时刻只有一个线程获得对相同监视器的锁定，当同步代码执行完成之后，该线程会释放改同步监视器的锁
 */
class Account
{
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
    public Account(String name, double amount)
    {
        this.name = name;
        this.amount  = amount;
    }
}


public class TestSynchronized extends Thread{

    //模拟用户账户
    private Account account;

    //当前取钱线程锁希望取的钱数
    private double drawAmount;

    public TestSynchronized(String tHreadName, Account account, double drawAmount)
    {
        super(tHreadName);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    //多个线程修改同一个数据时，将涉及到数据安全问题
    public void run()
    {
        /**
         * 使用account作为同步监视器，任何线程进入下面同步代码块之前，必须先获得对
         * account账户的锁定，其他线程无法获得锁，也就无法修改他
         * 加锁-》修改-》释放锁
         */
        synchronized (this.account)
        {
            //如果余额大于取钱
            if(this.account.getAmount() >= drawAmount)
            {
                System.out.println(getName()+"取钱成功，吐出钞票"+drawAmount);
                try
                {
                    Thread.sleep(1);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                account.setAmount(this.account.getAmount()-drawAmount);
                System.out.println("余额为"+this.account.getAmount());
            }else
            {
                System.out.println("取钱失败,余额不足"+drawAmount);
            }
        }
    }

    public static void main(String[] args)
    {
        Account account = new Account("父母的工行卡",1000);

        new TestSynchronized("老大",account, 900).start();
        new TestSynchronized("老二",account, 900).start();
    }
}
