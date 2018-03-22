package TestInterface;

public class OutputTest {

    public static void  main(String[] args)
    {
        Output a;  //用接口来声明变量，方便扩展

        //访问接口中的MAX_CACHE_LINE，
        System.out.println(Output.MAX_CACHE_LINE);

        System.out.println(Output.staticTest());
    }
}
