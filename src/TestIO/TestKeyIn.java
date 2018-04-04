package TestIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 输入、输出流体系提供了两个转换流，这两个转换流用于实现将字节流转换成字符流，其中InputStreamReader将字节流转换成字符
 * 输入流，OutputStreamWriter将字节流转化成字符输出流。
 *
 * System.in包装成BufferedReader, BufferedReader流具有缓冲功能，它可以一次读取一行文本，以换行符作为标志
 *
 *
 */
public class TestKeyIn {
    public static void main(String[] args)
    {
        try
        {
            //将System.in对象转化成Reader对象，下面将字节流转换为字符流，BufferedReader具有一个readLine方法，可以非常
            //方便的一次读取一行内容
            InputStreamReader reader = new InputStreamReader(System.in);

            //将普通的Reader包装成BufferedReader
            BufferedReader br = new BufferedReader(reader);

            String line = null;

            //采用循环方式来读取
            while ((line = br.readLine()) != null)
            {
                if(line.equals("exit"))
                {
                    System.exit(1);
                }

                System.out.println("输入内容为:"+line);
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
