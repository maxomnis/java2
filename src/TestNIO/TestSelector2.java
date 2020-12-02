package TestNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 3.5.4 选择器使用流程使用选择器，主要有以下三步：（1）获取选择器实例；（2）将通道注册到选择器中；（3）轮询感兴趣的IO就绪事件（选择键集合
 *
 *  开发discard服务器，
 *  仅仅读取客户端的输入数据，然后读取完成之后直接关闭客户端通道，并且读取到到数据直接抛弃
 */
public class TestSelector2 {
    public static void  main(String[] args) throws IOException {

        //1. 创建selector实例
        Selector selector = Selector.open();

        //2.将通道注册到选择器实例,获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(20000));

        /**
         * 注册到选择器上
         * 可供选择器监控的通道IO事件类型，包括以下四种：
         * （1）可读：SelectionKey.OP_READ
         * （2）可写：SelectionKey.OP_WRITE
         * （3）连接：SelectionKey.OP_CONNECT
         *  (4）接收：SelectionKey.OP_ACCEPT
         */

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        /**
         * 需要迭代集合的每一个选择键，根据具体IO事件类型，执行对应的业务操作。大致的处理流程如下
         */


        //强调一下，select()方法返回的数量，指的是通道数，而不是IO事件数，准确地说，是指发生了选择器感兴趣的IO事件的通道数
        /**
         * 用于选择就绪的IO事件的select()方法，有多个重载的实现版本，具体如下：
         * （1）select()：阻塞调用，一直到至少有一个通道发生了注册的IO事件。
         * （2）select(long timeout)：和select()一样，但最长阻塞时间为timeout指定的毫秒数。
         * （3）selectNow()：非阻塞，不管有没有IO事件，都会立刻返回。
         */
        while (selector.select()>0) {

            /**
             * 通过Selector选择器的select()方法，选出已经注册的、已经就绪的IO事件，
             * 保存到SelectionKey选择键集合中。SelectionKey集合保存在选择器实例内部，
             * 是一个元素为SelectionKey类型的集合（Set）。调用选择器的selectedKeys()方法，
             * 可以取得选择键集合。
             */
            Set selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()){
                SelectionKey key = (SelectionKey) keyIterator.next();


                //根据具体的io事件类型，执行对应的业务操作

                //连接就绪
                if(key.isAcceptable()){
                    System.out.println("来客人啦.....");

                    //若选择键的io事件是"连接就绪"，就获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    //切换为非阻塞模式
                    socketChannel.configureBlocking(false);

                    //将新链接通道的可读事件，注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);


                }else if(key.isConnectable())
                {
                    System.out.println("传输通道建立成功");

                }else if(key.isReadable())
                {
                    System.out.println("传输通道可读");

                    SocketChannel socketChannel = (SocketChannel) key.channel();

                    //读取数据，然后丢弃
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    int length = 10;

                    while ((length = socketChannel.read(byteBuffer)) > 0)
                    {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, length));
                        byteBuffer.clear();
                    }

                    socketChannel.close();

                }else if(key.isWritable())
                {
                    System.out.println("传输通道可写");
                }

                //处理完之后，移除选择键
                //处理完成后，需要将选择键从这个SelectionKey集合中移除，防止下一次循环的时候，被重复的处理
                keyIterator.remove();
            }
        }

    }
}
