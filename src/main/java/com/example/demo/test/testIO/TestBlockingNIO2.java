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
 * @ClassName 类名 TestBlockingNIO2
 * @date 2020/6/19 17:43
 * @注释：
 */
public class TestBlockingNIO2 {

    /**客户端*/
    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

        FileChannel inChannel = FileChannel.open(Paths.get("F:/text.txt"), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (inChannel.read(byteBuffer) != -1){
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        //。。。。。。。。关闭客户端输出通道
        socketChannel.shutdownOutput();
        //接收服务端返回
        int len;
        while ((len = socketChannel.read(byteBuffer)) != -1){
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array(),0,len));
            byteBuffer.clear();
        }

        inChannel.close();
        socketChannel.close();
    }

    /**服务端*/
    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9898));
        SocketChannel socketChannel = serverSocketChannel.accept();
        FileChannel outChannel = FileChannel.open(Paths.get("F:/test.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (socketChannel.read(byteBuffer) != -1){
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        //发送反馈给客户端
        byteBuffer.put("服务端接收数据成功".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        byteBuffer.clear();
        outChannel.close();
        socketChannel.close();
        serverSocketChannel.close();
    }
}
