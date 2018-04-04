package TestIO;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 测试字符流,输入操作
 */
public class TestReader {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        FileReader fis = new FileReader("E:/java2/src/TestIO/TestInputeStream.java");

        //创建一个长度为1024的“竹筒”
        char[] bbuf = new char[200];

        //用来保存实际读取的字节数
        int hasRead = 0;

        while ((hasRead = fis.read(bbuf)) > 0)
        {
            //取出“竹筒”中的水滴（字节）数组转换成字符串输入
            System.out.println(new String(bbuf, 0 , hasRead));
            //System.out.println("hasRead=" +hasRead);
        }

        //关闭文件输入流，放在finally块里更安全s
        fis.close();
    }
}
