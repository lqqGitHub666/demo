package com.example.demo.test.testIO.group_chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author 作者 lqq
 * @ClassName 类名 GroupClient
 * @date 2021/1/17 14:30
 * @注释：
 */
public class GroupClient {

    private SocketChannel socketChannel;

    private Selector selector;

    public GroupClient() {
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress("localhost",6667));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            new Thread(() -> {
                while (true){
                    try {
                        int select = selector.select();
                        if (select>0){
                            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                            while (iterator.hasNext()){
                                SelectionKey nextKey = iterator.next();
                                if (nextKey.isReadable()){
                                    SocketChannel channel = (SocketChannel) nextKey.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    channel.read(byteBuffer);
                                    System.out.println(new String(byteBuffer.array()));
                                }
                                iterator.remove();
                            }
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg){
        ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
        try {
            socketChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        GroupClient client = new GroupClient();
        while (true){
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            client.sendMessage(client.socketChannel.getLocalAddress() +":"+ next);
        }
    }
}
