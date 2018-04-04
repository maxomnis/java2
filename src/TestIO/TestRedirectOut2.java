package TestIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 重定向输入
 */
public class TestRedirectOut2 {
    public static void main(String[] args) throws IOException
    {
        try
        {
            FileInputStream fis = new FileInputStream("E:/java2/src/TestIO/out.txt");

            //将标准输入重定向到fis
            System.setIn(fis);

            //使用System.in创建Scanner对象，用于获取标准输入
            Scanner sc = new Scanner(System.in);

            sc.useDelimiter("\n");

            while (sc.hasNext())
            {
                System.out.println("键盘输入内容是"+sc.next());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
