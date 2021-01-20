package com.example.demo.test.testSocket.chat_room;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: Server
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2021/1/18 13:43
 * @Version: 1.0
 */
public class Server {

    private ServerSocketChannel serverSocketChannel;

    private Selector selector;

    public Server() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(6667));
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen(){
        while (true){
            try {
                int select = selector.select();
                if (select > 0){
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()){
                        SelectionKey selectionKey = iterator.next();
                        if (selectionKey.isAcceptable()){
                            accept();
                        }else if (selectionKey.isReadable()){
                            read(selectionKey);
                        }
                        iterator.remove();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void read(SelectionKey selectionKey) {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Object address;
        try {
            address = socketChannel.getRemoteAddress();
        } catch (IOException e) {
            address = "";
        }
        try {
            socketChannel.read(byteBuffer);
            String msg = address+" say:"+ new String(byteBuffer.array());
            System.out.println(msg);
            forwardToOtherClients(msg,socketChannel);
        } catch (IOException e) {
            try {
                System.out.println(address+"断开连接...");
                selectionKey.cancel();
                socketChannel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void forwardToOtherClients(String msg, SocketChannel socketChannel) throws IOException {
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys) {
            SelectableChannel channel = key.channel();
            if (channel instanceof SocketChannel && socketChannel != channel){
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                ((SocketChannel) channel).write(byteBuffer);
            }
        }
    }

    private void accept() {
        try {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector,SelectionKey.OP_READ);
            System.out.println("客户端"+socketChannel.getRemoteAddress()+"已连接");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().listen();
    }
}
