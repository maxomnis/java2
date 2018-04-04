package TestNIO;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 使用文件锁
 *
 */
public class TestFileLock {
    public static void  main(String[] args)
    {
        try
        {
            FileChannel channel = new FileOutputStream("a.txt").getChannel();

            //使用非阻塞方式对指定文件加锁
            FileLock lock = channel.tryLock();
            Path path = Paths.get(".");

            //程序暂定10s
            Thread.sleep(10000);
            //释放锁
            lock.release();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
