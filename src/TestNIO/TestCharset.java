package TestNIO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * 明文到二进制的叫编码
 * 二进制到明文的叫解码
 */
public class TestCharset {

    public static void main(String[] args) throws Exception
    {
        //创建简体中文对应的Charset
        Charset cn = Charset.forName("GBK");

        //获取cn对应的编码和解码器
        CharsetEncoder cnEncoder = cn.newEncoder();
        CharsetDecoder cnDecoder = cn.newDecoder();

        //创建一个CharBuffer对象
        CharBuffer cbuff = CharBuffer.allocate(8);
        cbuff.put('孙');  //一个字符占2个字节，所以下面的capacity=6，这里有三个字
        cbuff.put('悟');
        cbuff.put('空');
        cbuff.flip();

        //将CharBuffer中的字符序列转换为字节序列
        ByteBuffer bbuff = cnEncoder.encode(cbuff);

        System.out.println("capacity="+bbuff.capacity());
        for(int i = 0; i < bbuff.capacity(); i++)
        {
            System.out.println(bbuff.get(i)+" ");
        }

        //将ByteBuffer的数据解码成字符序列
        System.out.println("\n"+cnDecoder.decode(bbuff));

        System.out.println(new String("哈哈").getBytes("GBK"));
        System.out.println(new String("哈哈").getBytes("UTF-8"));
    }
}
