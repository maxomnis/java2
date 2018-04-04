package TestIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 重定向输入输出
 */
public class TestRedirectOut {

    public static void main(String[] args) throws IOException
    {
        try
        {
            PrintStream ps = new PrintStream(new FileOutputStream("E:/java2/src/TestIO/out.txt"));

            //将标准输出重定向到ps输出流
            System.setOut(ps);

            //向标准输出，输出一个字符串
            System.out.println("普通字符串");

            System.out.println(new TestRedirectOut());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
