package com.example.demo.test.testIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @ClassName: TestNonBlockingNIO
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/21 21:36
 * @Version: 1.0
 *
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
 */
public class TestNonBlockingNIO {

    /**客户端*/
    @Test
    public void client() throws IOException {
        //1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

        //2.切换为非阻塞模式
        socketChannel.configureBlocking(false);

        //3.分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //4.发送数据给服务端
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String str = scan.next();
            byteBuffer.put((new Date().toString() + "\n" + str).getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
            if("close".equals(str)){
                break;
            }
        }

        //5.关闭通道
        socketChannel.close();
    }

    /**服务端*/
    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //2.绑定端口
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //3.切换非阻塞模式
        serverSocketChannel.configureBlocking(false);

        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道注册到选择器上，并指定“监听接收事件”
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        //6.轮询式的获取选择器上已经“准备就绪”的事件
        while (selector.select() > 0){
            //7.获取当前选择器中所有注册的“选择键（已就绪的监听事件）”
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            //8.获取准备就绪的事件
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                //9.判断具体是什么事件准备就绪
                if (key.isAcceptable()){
                    //10.如果“接收就绪”,获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //11.切换非阻塞模式
                    socketChannel.configureBlocking(false);
                    //12.将该通道注册到选择器上
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if (key.isReadable()){
                    //13.如"读就绪"，获取选择器上“读就绪”状态的通道
                    SocketChannel readChannel = (SocketChannel) key.channel();
                    //14.读取数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int len;
                    while ((len = readChannel.read(byteBuffer)) > 0){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(),0,len));
                        byteBuffer.clear();
                    }
                }
                //15.取消选择键SelectionKey
                keyIterator.remove();
            }
        }
    }

}
