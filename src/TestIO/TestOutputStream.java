package TestIO;

/**
 * 测试字节流输出操作
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestOutputStream {
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("E:/java2/src/TestIO/TestInputeStream.java");
            FileOutputStream fos = new FileOutputStream("E:/java2/src/TestIO/newfile.txt");

            byte[] bbuf = new byte[32];

            int hasRead = 0;

            while ((hasRead = fis.read(bbuf)) > 0)
            {
                //每读取一次，即写入文件输出流，读了多少，就写多少
                fos.write(bbuf, 0 ,hasRead);
            }

            fis.close();
            fos.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
