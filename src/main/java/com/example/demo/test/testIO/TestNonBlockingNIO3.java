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

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8090));

        socketChannel.configureBlocking(false);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);
        while (true){
            String s = scanner.nextLine();
            System.out.println("client:"+s);
            byteBuffer.put(s.getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            int line;
//            while ((line = socketChannel.read(byteBuffer)) > 0 ){
//                byteBuffer.flip();
//                System.out.println(new String(byteBuffer.array(),0,line));
//                byteBuffer.clear();
//            }
            if ("bye".equals(s)) {
                break;
            }
        }
        socketChannel.close();
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
                        byteBuffer.put("你的消息已发送到服务器".getBytes());
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        byteBuffer.clear();
                    }
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
