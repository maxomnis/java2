package TestNIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * 这玩意具体有啥用，没看明白，如果映射的文件大了咋办？
 *
 * NIO中一个连接就是用一个Channel（通道）来表示。大家知道，从更广泛的层面来说，一个通道可以表示一个底层的文件描述符
 * ，例如硬件设备、文件、网络连接等。然而，远远不止如此，除了可以对应到底层文件描述符，
 * JavaNIO的通道还可以更加细化。例如，对应不同的网络传输协议类型，在Java中都有不同的NIO Channel（通道）实现
 *
 * 四种Channel（通道）实现：FileChannel、SocketChannel、ServerSocketChannel、DatagramChannel
 * 对于以上四种通道，说明如下：
 * （1）FileChannel文件通道，用于文件的数据读写。
 * （2）SocketChannel套接字通道，用于Socket套接字TCP连接的数据读写。（
 *  3）ServerSocketChannel服务器嵌套字通道（或服务器监听通道），允许我们监听TCP连接请求，为每个监听到的请求，创建一个SocketChannel套接字通道。
 * （4）DatagramChannel数据报通道，用于UDP协议的数据读写。
 */


public class TestChannel {
    public static void main(String[] args)
    {
        File f = new File("TestBuffer.java");

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

            //将outchile的数据，写到bufer里面
            outChannel.write(buffer);

            //再次调用buffer的clear方法，复原limit,position的位置
            buffer.clear();

            //创建解码器(CharsetDecoder)对象
            CharsetDecoder decoder = charset.newDecoder();

            //使用解码器将bytebuffer转换成charbuffer
            CharBuffer charBuffer = decoder.decode(buffer);

            inChannel.close();
            outChannel.close();
            System.out.println(charBuffer);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
