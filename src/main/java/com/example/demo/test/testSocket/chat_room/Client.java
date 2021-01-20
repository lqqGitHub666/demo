package com.example.demo.test.testSocket.chat_room;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @ClassName: Client
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2021/1/18 14:04
 * @Version: 1.0
 */
public class Client {

    private SocketChannel socketChannel;

    private Selector selector;

    public Client() {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress("localhost",6667));
            socketChannel.configureBlocking(false);
            selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_READ);
            new Thread(() -> {
                while (true){
                    try {
                        int select = selector.select();
                        if (select > 0){
                            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                            while (iterator.hasNext()){
                                SelectionKey selectionKey = iterator.next();
                                SocketChannel channel = (SocketChannel) selectionKey.channel();
                                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                channel.read(byteBuffer);
                                String msg = new String(byteBuffer.array());
                                System.out.println(msg);
                                iterator.remove();
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg){
        if (StringUtils.isEmpty(msg)){
            return;
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
        try {
            socketChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        while (true){
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            client.sendMsg(next);
        }
    }
}
