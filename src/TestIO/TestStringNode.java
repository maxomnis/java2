package TestIO;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class TestStringNode {

    public  static void main(String[] args) throws IOException
    {
        String src = "从明天起，做一个幸福的人\n"
                  +"喂马，劈才，周有世界\n"
                  +"我有一所房子，面朝大海，春暖花开\n"
                  +"从明天起，和每一个亲人通信,告诉他们我的幸福,那幸福的闪电告诉我的,我将告诉每一个人";

        char[] buffer = new char[32];
        int hasRead = 0;
        try
        {
            StringReader sr = new StringReader(src);
                //循环读取字符串
                while ((hasRead = sr.read(buffer))> 0)
                {
                    System.out.println(new String(buffer, 0 ,hasRead));
                }

                System.out.println("------------------------------------------------------------------");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        try
        {
            /*
              创建StringWrtier时，实际上以一个StringBuffer作为输出节点（看StringWriter源码，实际上是对StringBuffer的
              封装）
              下面指定的 10 StringBuffer的长度
             */
            StringWriter sw = new StringWriter(10);
            sw.write("从明天起，做一个幸福的人");
            sw.write("喂马、劈柴，周游世界");
            sw.write("从明天起，关心粮食和蔬菜");
            sw.write("我有一所房子，面朝大海，春暖花开");
            sw.write("从明天起，和每一个亲人通信");
            sw.write("告诉他们我的幸福");

            System.out.println(sw.toString());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
