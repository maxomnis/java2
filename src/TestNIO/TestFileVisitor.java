package TestNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;


/**
 * 使用FileVisitor遍历指定目录下的所有文件和子目录
 */
public class TestFileVisitor {
    public static void main(String[] args) throws IOException
    {
        Path path = Paths.get("E:/java2/src/TestNIO");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

            //访问文件的时候触发
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                      throws IOException
            {
                System.out.println("in visitFile....");
                return FileVisitResult.CONTINUE;
            }

            //
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e)
                      throws IOException
            {
                if (e == null) {
                    System.out.println("in postVisitDirectory....");
                    return FileVisitResult.CONTINUE;
                } else {
                    // directory iteration failed
                    throw e;
                }
            }
        });
    }
}
