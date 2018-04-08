package TestThreadNoticeByCondittion.TestThreadNotice;

/**
 * 取钱线程
 */
public class DrawThread  extends Thread{

    //模拟用户账户
    private Account account;

    //当前取钱数
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount)
    {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    //重复100次取钱操作
    public void run()
    {
        for(int i=0 ; i< 100; i++)
        {
            account.draw(drawAmount);
        }
    }
}
