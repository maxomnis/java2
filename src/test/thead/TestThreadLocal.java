package test.thead;

/**
 * ThreadLocal
 *
 * ThreadLocal 就是Thread local variable（线程局部变量的意思），它作用很简单，就是为每个使用该变量的线程都提供一个变量的
 * 副本，使每个线程的都可以独立地改变自己的副本，而不会和其他的线程冲突。从线程的角度看，就好像每个线程都拥有该变量一样
 *
 * ThreadLocal的用法非常简单，就三个方法：
 * 1. T get() 返回此线程局部变量中当前线程副本的值
 * 2. void remove() 删除此线程局部变量中当前线程的值
 * 3. void set(T value) 设置此线程局部变量中当前线程副本中的值
 */

class  Account_8
{
    /*
      定义一个ThreadLocal类型的变量，该变量是一个线程局部变量，每个线程都会保留该变量的副本
     */
    private ThreadLocal<String> name = new ThreadLocal<>();

    public Account_8(String str)
    {
        this.name.set(str);
        //访问当前线程的name的副本值
        System.out.println("------"+this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void  setName(String name)
    {
        this.name.set(name);
    }
}

class  MyThread extends Thread{

    //定义一个Account类型的成员变量
    private Account_8 account;

    public MyThread(Account_8 account, String name)
    {
        super(name);
        this.account = account;
    }

    public void run()
    {
        //循环10次
        for(int i=0; i<10 ;i++)
        {
            //当i==6时，将当前的账户的名字替换成当前的线程名
            if(i == 6)
            {
                account.setName(getName());
            }
            System.out.println(account.getName()+" 账户的i值"+i);
        }
    }


}

public class TestThreadLocal
{
        public static void main(String[] args)
        {
            Account_8 at = new Account_8("初始化名");

            new MyThread(at, "线程甲").start();
            new MyThread(at, "线程乙").start();
        }
}
