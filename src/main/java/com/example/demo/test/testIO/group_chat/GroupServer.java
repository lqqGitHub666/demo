package com.example.demo.test.testIO.group_chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 作者 lqq
 * @ClassName 类名 GroupServer
 * @date 2021/1/17 14:08
 * @注释：
 */
public class GroupServer {

    private ServerSocketChannel serverSocketChannel;

    private Selector selector;

    public GroupServer(){
        try {
            serverSocketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(6667));
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
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
                    while (keyIterator.hasNext()){
                        SelectionKey selectionKey = keyIterator.next();
                        if (selectionKey.isAcceptable()){
                            accept();
                        }else if (selectionKey.isReadable()){
                            read(selectionKey);
                        }
                        keyIterator.remove();
                    }
                }
            }catch (IOException e) {

            }
        }
    }

    /**接受客户端数据*/
    private void read(SelectionKey key) {
        SocketChannel channel = null;
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel = (SocketChannel) key.channel();
            channel.read(byteBuffer);
            String str = new String(byteBuffer.array());
            System.out.println(str);
            //转发给其他客户端
            sendMsgToOthersClient(channel,str);
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + " 客户端断开连接...");
                //取消key的注册
                key.cancel();
                channel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    private void sendMsgToOthersClient(SocketChannel channel,String msg) throws IOException {
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys) {
            Channel channel1 =  key.channel();
            if (channel1 instanceof SocketChannel && channel1!=channel){
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                SocketChannel dest = (SocketChannel)channel1;
                dest.write(buffer);
            }

        }
    }

    /**接受客户端连接*/
    private void accept() throws IOException {
        SocketChannel channel = serverSocketChannel.accept();
        channel.configureBlocking(false);
        channel.register(selector,SelectionKey.OP_READ);
        System.out.println(channel.getRemoteAddress()+"已连接服务器");
    }

    public static void main(String[] args) {
        GroupServer groupServer = new GroupServer();
        groupServer.listen();
    }
}
