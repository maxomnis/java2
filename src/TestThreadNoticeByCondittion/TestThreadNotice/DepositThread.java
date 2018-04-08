package TestThreadNoticeByCondittion.TestThreadNotice;

/**
 * 存钱线程
 */
public class DepositThread extends  Thread{
    //模拟用户账户
    private Account account;

    //当前存钱数
    private double depositAccount;

    public DepositThread(String name, Account account, double depositAccount)
    {
        super(name);
        this.account = account;
        this.depositAccount = depositAccount;
    }

    //重复100次取钱操作
    public void run()
    {
        for(int i=0 ; i< 100; i++)
        {
            account.deposit(depositAccount);
        }
    }
}
