package TestNIO;

import java.nio.CharBuffer;

/**
 *  nio 其实就是new io的意思，
 *  NIO   (new io全写，这些类都被放在java.nio包以及子包下，并且对原java.io包中的很多类都以NIO为基础进行了改写，
 *  新增了满足NIO的功能。新IO采用内存映射文件的方式来处理输入输出，
 *  新IO将文件或文件的一段映射为一个内存中，这样就可以像访问内存一样访问内存了)
 *
 *  使用buffer
 *  从内部结构上看，buffer就像一个数组，它可以保存多个类型相同的数据。buffer是一个抽象类，其最常用的子类是ByteBufer,
 *  它可以在底层字节数组上进程get/set操作，除了ByteBuffer之外，对应于其他基本数据类型（boolean除外）都有相应的Buffer类
 *  CharBuffer, ShortBuffer,IntBuffer
 *
 * buffer三个重要概念：
 * 1. 容量（capacity），缓冲区容量(capacity) 表示该buffer最大容量，即最多可以存储多少数据。缓冲区不可能为负值，创建后
 * 不能改变
 * 2. 界限（limit） , 第一个不应该读出或者写入的缓冲区索引位置。也就是说，位于limit后的数据既不可被读，也不可被写。
 * 3. 位置（position）， 用于指明下一个可被读出的或者写入的缓冲区位置索引（类似于IO的索引）。当使用Buffer从Channel中
 * 读取数据时，position的值恰好等于读取到多少数据。
 */
public class TestBuffer {
    public static void main(String[] args)
    {
        //创建Buffer
        CharBuffer buff = CharBuffer.allocate(8);  //buff的长度为8

        System.out.println("capacity:"+buff.capacity());
        System.out.println("limit:"+buff.limit());
        System.out.println("position:"+buff.position());

        //放入元素
        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("加入三个元素后,position="+buff.position());

        buff.flip(); //将limit设置为position的位置
        System.out.println("执行flip()之后, limit="+buff.limit());
        System.out.println("position="+buff.position());

        //取出第一个元素
        System.out.println("第一个元素（position=0）"+buff.get());
        System.out.println("取出一个元素后,position="+buff.position());

        buff.clear(); //调用clear()方法，clear并不是清空buff,而是将postition置为0，将limit置为capacity；这样为再次为
        //向buff中装入数据做好准备

        System.out.println("执行clear后， limit="+buff.limit());
        System.out.println("执行clear后， position="+buff.position());

        System.out.println("执行clear后，缓冲区内容并没有被清除:"+"第三个元素为:"+buff.get(2));

        System.out.println("执行绝对读取之后，position="+buff.position());
    }
}
