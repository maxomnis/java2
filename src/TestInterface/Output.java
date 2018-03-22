package TestInterface;

/**
 * 一个 *.java文件中，只能有一个public修饰的接口
 */
public interface Output {

    //接口里定义的成员变量只能是常量,jdk会自动加上static final
    int MAX_CACHE_LINE=50;

    //接口里定义的普通方法只能是public的抽象方法，如果没有public，则只能在当前包访问
    void out();

    void getData(String msg);

    //在接口中定义默认方法，需要使用default修饰
    default void print(String...msgs)
    {
        for(String msg :msgs)
        {
            System.out.println(msg);
        }
    }

    //在接口中定义默认方法，需要使用default修饰
    default void  test()
    {
        System.out.println("默认的test()方法");
    }

    //在接口中定义类方法，需要使用static修饰
    static  String staticTest()
    {
        return "接口里的类方法";
    }
}
