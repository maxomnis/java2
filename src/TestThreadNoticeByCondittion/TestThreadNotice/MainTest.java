package TestThreadNoticeByCondittion.TestThreadNotice;

/**
 * 调用存钱，取钱操作
 *
 * 程序执行到最后阻塞，这里是阻塞在存钱的wait()操作，为什么呢？
 * 因为，取钱100次，存款加起来300次；最后取钱执行完之后，存款之后，么有人再取了
 */
public class MainTest {
    public static void main(String[] args)
    {
        //创建一个账号
        Account account = new Account("123456", 0);
        new DrawThread("取钱者", account, 800).start();
        new DepositThread("存钱者A", account, 800).start();
/*
        new DepositThread("存钱者B", account, 800).start();
        new DepositThread("存钱者C", account, 800).start();
*/




    }
}
