package com.example.demo.test.testIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestBlockingNio
 * @date 2020/6/19 16:34
 * @注释：
 * 一、使用NIO完成网络通信的三个核型：
 *  1.通道（Channel）：负责连接
 *      java.nio.channel.Channel接口：
 *          |--SelectableChannel
 *              |--SocketChannel
 *              |--ServerSocketChannel
 *              |--DatagramChannel
 *
 *              |--Pipe.SinkChannel
 *              |--Pipe.SourceChannel
 *
 *
 *  2.缓冲区（Buffer）：负责数据的存取
 *
 *  3.选择器（Selector）：是SelectableChannel 的多路复用器，用于监控 SelectableChannel 的IO 的状况
 *
 */
public class TestBlockingNIO {

    /**客户端*/
    @Test
    public void client() throws IOException {
        //1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

        FileChannel inChannel = FileChannel.open(Paths.get("F:/text.txt"), StandardOpenOption.READ);

        //2.分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //3.读取本地文件，并发送到服务端
        while (inChannel.read(byteBuffer) != -1){
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        //4.关闭通道
        socketChannel.close();
        inChannel.close();
    }

    /**服务端*/
    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        FileChannel outChannel = FileChannel.open(Paths.get("F:/test.txt"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
        //2.绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));
        //3.获取客户端连接的通道
        SocketChannel client = serverSocketChannel.accept();
        //4.分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //5.接收客户端的数据，并保存到本地
        while (client.read(byteBuffer) != -1){
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        //6.关闭通道
        client.close();
        outChannel.close();
        serverSocketChannel.close();
    }

}
