package com.example.demo.test.testIO;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @ClassName: TestPipe
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/21 23:40
 * @Version: 1.0
 */
public class TestPipe {

    @Test
    public void test() throws IOException {
        //1.获取管道
        Pipe pipe = Pipe.open();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //2.将缓冲区数据写入管道
        Pipe.SinkChannel sinkChannel = pipe.sink();
        byteBuffer.put("通过单项管道发送数据".getBytes());
        byteBuffer.flip();
        sinkChannel.write(byteBuffer);

        //3.读取缓冲区中的数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        byteBuffer.flip();
        int len = sourceChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array(),0,len));

        sinkChannel.close();
        sourceChannel.close();
    }

}
