package TestDesignPatterns;

class Singleton {
    //使用一个类变量来缓存曾经创建的实例
    private static Singleton instance;

    //对构造器使用private修饰，隐藏该构造器，不允许自由访问类的成员变量和实现细节
    private Singleton()
    {

    }

    /**
     * 提供一个静态方法，用于返回Singleton对象，
     * 该方法加入自定义控制，保证只有一个Singleton对象
     * @return 创建实例
     */
    public static Singleton getInstance()
    {

        if(instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }

}


public class SingletonTest
{
    public static void main(String[] args)
    {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}