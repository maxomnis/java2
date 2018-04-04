package TestNIO;

/**
 * 这玩意具体有啥用，没看明白，如果映射的文件大了咋办？
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class TestChannel {
    public static void main(String[] args)
    {
        File f = new File("E:/java2/src/TestNIO/TestChannel.java");

        try
        {
            //创建FileInputStream,以该文件输入流创建FileChannel
            FileChannel inChannel = new FileInputStream(f).getChannel();

            //以 文件输出流 创建FileChannel,用以控制输出
            FileChannel outChannel = new FileOutputStream("E:/java2/src/TestNIO/a.txt").getChannel();

            //将FileChannel里的全部数据映射成ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());

            //使用GBK的字符集来创建解码器
            Charset charset = Charset.forName("GBK");

            //直接将buffer里的数据全部输出
            outChannel.write(buffer);

            //再次调用buffer的clear方法，复原limit,position的位置
            buffer.clear();

            //创建解码器(CharsetDecoder)对象
            CharsetDecoder decoder = charset.newDecoder();

            //使用解码器将bytebuffer转换成charbuffer
            CharBuffer charBuffer = decoder.decode(buffer);

            //
            System.out.println(charBuffer);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
