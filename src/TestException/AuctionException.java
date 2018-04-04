package TestException;

/**
 * 用于自定义异常都应该继承Exception基类，如果希望自定义Runtime异常，则应该继承RuntimeException基类，定义
 * 异常类时通常提供两个构造函数，一个无参构造函数，一个带一个字符串参数的构造函数。这个字符串作为该异常对象
 * 的描述信息(也就是异常对象的getMessage())
 */
public class AuctionException extends Exception{

    //无参构造函数
    public AuctionException() {}

    //带一个字符串的构造函数
    public AuctionException(String msg)
    {
        super(msg); //调用父类的构造函数
    }
}
