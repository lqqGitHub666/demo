package com.example.demo.test.testIO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestBuffer
 * @date 2020/6/18 14:32
 * @注释：
 *
 * 一、 通道：(Channel)：用于源节点与目标节点的链接。在java NIO中负责缓冲区中数据的传输，Channel本身不存储数据，因此需要配合缓冲区进行传输。
 *
 * 二、通道的主要实现类
 *  java.nio.channels.Channel接口
 *      |--FileChannel（完成本地文件传输IO）
 *      |--SocketChannel（用于TCP网络IO）
 *      |--ServerSocketChannel（用于TCP网络IO）
 *      |--DatagramChannel（用于UDP网络IO）
 * 三、获取通道
 * 1.Java针对支持通道的类提供了getChannel()方法
 *      本地IO：
 *      FileInputStream/FileOutputStream
 *      RandomAccessFile
 *
 *      网络IO：
 *      Socket
 *      ServerSocket
 *      DatagramSocket
 *
 * 2.在JDK1.7中的NIO.2针对各个通道提供了静态方法open()
 * 3.在JDK1.7中的NIO.2的Files工具类的newByteChannel()
 *
 * 四、通道之间的数据传输(直接缓冲区)
 * transferFrom()
 * transferTo()
 */
public class TestChannel {

    /**通道之间数据传输(直接缓冲区)*/
    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
//        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    /**2.使用直接缓冲区完成文件的的复制(内存映射文件)*/
    @Test
    public void test2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        //直接对缓冲区进行数据文件的读写操作
        byte[] bytes = new byte[inMappedByteBuffer.limit()];
        inMappedByteBuffer.get(bytes);
        outMappedByteBuffer.put(bytes);

        inChannel.close();
        outChannel.close();
    }


    /**1.利用通道完成文件的复制(非直接缓冲区)*/
    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("2.jpg");

        //①获取通道
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();

        //②分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //③将inChannel通道中的数据存入缓冲区
        while (inChannel.read(byteBuffer) != -1){
            byteBuffer.flip();//切换成读取数据的模式
            //④将缓冲区的数据读到outChannel通道
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        outChannel.close();
        inChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }


}
