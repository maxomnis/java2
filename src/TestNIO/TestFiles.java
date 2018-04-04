package TestNIO;

/**
 * Files工具的使用
 *
 * 读者应该熟练的使用Files工具类，它大大的简化了IO的操作
 */

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestFiles {
    public static void main(String[] args) throws Exception
    {

        //文件复制
        Files.copy(Paths.get("E:/java2/src/TestNIO/TestFiles.java"), new FileOutputStream("E:/java2/src/TestNIO/TestFiles.txt"));

        //判断是否为隐藏文件
        System.out.println("是否是隐藏文件"+Files.isHidden(Paths.get("E:/java2/src/TestNIO/TestFiles.java")));

       //一次性读取 TestFiles.java文件的所有行
        List<String> lines = Files.readAllLines(Paths.get("E:/java2/src/TestNIO/TestFiles.java"), Charset.forName("utf-8"));

        System.out.println(lines);

        //判断指定文件的大小
        System.out.println("大小为"+ Files.size(Paths.get("E:/java2/src/TestNIO/TestFiles.java")));
    }

}
