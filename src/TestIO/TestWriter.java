package TestIO;

import java.io.FileWriter;
import java.io.IOException;

public class TestWriter {
    public static void main(String[] args) throws IOException
    {
        try
        {
            FileWriter fw = new FileWriter("E:/java2/src/TestIO/popm.txt");

            fw.write("李商隐\n");
            fw.write("李商隐\n");
            fw.write("李商隐\n");
            fw.write("李商隐\n");
            fw.write("李商隐\n");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
