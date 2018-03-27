package TestBaseLib;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * System类代表当前java程序的运行平台，程序不能创建system类的对象，system提供了一些类变量和类方法，
 * 允许直接通过system类来调用这些变量和类方法
 */
public class TestSystem {

    public static void main(String[] args)
    {
        //获取系统所在环境变量
        Map <String ,String> env = System.getenv();

        for(String name:env.keySet())
        {
            System.out.println(name+"---->"+env.get(name));
        }

        //获取指定环境变量值
        System.out.println(System.getenv("JAVA_HOME"));

        //获取所有的系统属性
        Properties props = System.getProperties();

        //将获取所有系统属性保存在文件中
        try
        {
            props.store(new FileOutputStream("props.txt"),"system proprties") ;
        }catch (Exception e)
        {
            e.getMessage();
        }

        System.out.println(System.getProperty("os.name"));
    }
}