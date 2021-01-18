package com.example.demo.test.testIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestNonBlockingNIO3
 * @date 2020/7/14 14:05
 * @注释：
 */
public class TestNonBlockingNIO3 {

    @Test
    public void client() throws IOException {

        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.configureBlocking(false);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8090);
        if (!socketChannel.connect(inetSocketAddress)){
            while (!socketChannel.finishConnect()){
                System.out.println("未完成连接");
            }
        }
        String a = "hello lqq";
        ByteBuffer byteBuffer = ByteBuffer.wrap(a.getBytes());
        socketChannel.write(byteBuffer);
        System.in.read();

    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8090));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (selector.select() > 0){
            Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
            while (selectionKeyIterator.hasNext()){
                SelectionKey selectionKey = selectionKeyIterator.next();
                if (selectionKey.isAcceptable()){
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if (selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    int line;
                    while ((line = socketChannel.read(byteBuffer)) > 0){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(),0,line));
                        byteBuffer.clear();
                    }
//                    socketChannel.register(selector,SelectionKey.OP_WRITE);
                }
                selectionKeyIterator.remove();
            }
        }
    }

    {
        System.out.println("hahaha");
    }
    static {
        System.out.println("static");
    }

    public TestNonBlockingNIO3() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        {
            System.out.println(123456);
        }
        new TestNonBlockingNIO3();
        new TestNonBlockingNIO3();
        new TestNonBlockingNIO3();
    }
}
