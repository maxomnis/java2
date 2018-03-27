package TestBaseLib;

/**
 * Runtime类代表java程序的运行时环境，每个java程序都有一个与之对应的Runtime实例，
 * 应用程序通过该对象与运行时环境相连.
 */
public class TestRuntime extends Object{

    public static void main(String[] args)
    {
        Runtime rt = Runtime.getRuntime();
        System.out.println("处理器数量:"+rt.availableProcessors());
        System.out.println("空闲内存数:"+rt.freeMemory());
        System.out.println("总内存:"+rt.totalMemory());
        System.out.println("可用最大内存:"+rt.maxMemory());
    }
}
