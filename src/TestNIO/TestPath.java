package TestNIO;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 测试工具类Paths使用
 */
public class TestPath {
    public static void main(String[] args)
    {
        //以当前路径来创建Path对象
        Path path = Paths.get("E:/java2/src/TestNIO");

        System.out.println("path里包含的路径数量:"+path.getNameCount());
        System.out.println("path的根路径:"+path.getRoot());

        //获取path绝对路径
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);

        //获取绝对路径的根路径
        System.out.println("absolute path的根路径"+absolutePath.getRoot());

        System.out.println("absolute path包含的路径数量"+absolutePath.getNameCount());

        System.out.println(absolutePath.getName(0));
        System.out.println(absolutePath.getName(1));
        System.out.println(absolutePath.getName(2));

        //以多个path来构建path
        Path path2 = Paths.get("g:", "public", "codes");
        System.out.println(path2);
    }
}
