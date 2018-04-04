package TestNIO;

import java.nio.file.*;

/**
 * 监控文件变化
 */
public class TestFileWatch {
    public static void main(String[] args) throws  Exception
    {
        WatchService watchService = FileSystems.getDefault().newWatchService();

        //为C盘路径注册监听
        Paths.get("c:/").register(watchService,
                  StandardWatchEventKinds.ENTRY_CREATE,
                  StandardWatchEventKinds.ENTRY_DELETE,
                  StandardWatchEventKinds.ENTRY_MODIFY,
                  StandardWatchEventKinds.OVERFLOW
                  );

        while (true)
        {
            WatchKey key = watchService.take();
            for(WatchEvent<?> evnet :key.pollEvents())
            {
                System.out.println(evnet.context()+" 文件发生了"+evnet.kind()+"事件");
            }

            //重设Watchkey
            boolean valid = key.reset();

            //如果重设失败，退出监听
            if(!valid)
            {
                break;
            }
        }
    }
}
