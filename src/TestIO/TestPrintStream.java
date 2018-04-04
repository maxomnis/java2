package TestIO;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 处理流的用法
 * 处理流，它隐藏了底层设备上节点流的差异，并对外提供了方便的输入、输出方法，让程序只需关系高级流的操作
 * 使用处理流时的典型思路是，使用处理流来包装节点流，程序通过处理流来执行输入、输出功能，让节点流于底层的
 * I/O设备，文件交互。
 *
 * 识别处理流非常简单，只要流的构造参数不是一个物理节点，而是已经存在的流，那么这种流就一定是处理流；
 * 而所有节点流都是直接以物流IO节点作为构造函数的参数的
 *
 * 处理流的优势：
 * 1. 对开发人员来说，使用处理流进行输入、输出操作更简单
 * 2. 使用处理流的执行效率更高
 */
public class TestPrintStream {

    public static void  main(String[] args)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("E:/java2/src/TestIO/test.txt");
            PrintStream ps = new PrintStream(fos);  //处理流，包装了一个节点流
            {
                //将下面的内容写入到fos文件
                ps.println("普通字符串");
                ps.println(new TestPrintStream());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
