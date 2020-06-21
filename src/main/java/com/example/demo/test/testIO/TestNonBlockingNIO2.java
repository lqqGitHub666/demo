package com.example.demo.test.testIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @ClassName: TestNonBlockingNIO2
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/21 23:25
 * @Version: 1.0
 */
public class TestNonBlockingNIO2 {

    /**发送端*/
    @Test
    public void send() throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();

        datagramChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String str2 = scanner.next();
            buffer.put((new Date().toString() + "\n" + str2).getBytes());
            buffer.flip();
            datagramChannel.send(buffer,new InetSocketAddress("127.0.0.1",9898));
            buffer.clear();
            if (str2.equals("bye")){
                break;
            }
        }

        datagramChannel.close();
    }

    /**接收端*/
    @Test
    public void receive() throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();

        datagramChannel.configureBlocking(false);

        datagramChannel.bind(new InetSocketAddress(9898));

        Selector selector = Selector.open();

        datagramChannel.register(selector, SelectionKey.OP_READ);

        while (selector.select() > 0){
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                if (key.isReadable()){
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    datagramChannel.receive(byteBuffer);
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));
                }
            }
            keyIterator.remove();
        }
    }
}
