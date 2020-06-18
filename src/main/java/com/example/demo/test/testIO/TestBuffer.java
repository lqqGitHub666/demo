package com.example.demo.test.testIO;


import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @ClassName: TestBuffer
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/16 23:07
 * 缓冲区（Buffer）；在java nio中负责数据的存取，缓冲区就是数组，用于存储不同数据类型的数据
 * 根据数据类型不同（boolean 除外），提供了相应类型的缓冲区
 * ByteBuffer（最常用）
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过allocate()获取缓冲区
 * 二、缓冲区存取数据的两个核心方法
 * put()：存入数据到缓冲区
 * get()：获取缓冲区中的数据
 *
 * 四、缓冲区中的四个核心属性
 * capacity：表示缓冲区最大的存储数据的容量，一旦声明不能改变
 * limit：界限，表示缓冲区可以操作的数据的大小，（limit后数据不能进行读写）
 * position：位置，缓冲区中正在操作的数据的位置
 * mark：标记，表示标记记录当前position的位置，可以通过reset()恢复到mark的位置
 *
 * 0 <= mark <= position <= limit <= capacity
 *
 * 五、直接缓冲区与非直接缓冲区：
 * 非直接缓冲区：通过allocate() 方法分配的缓冲区，将缓冲区建立在jvm的内存中
 * 直接缓冲区：通过allocateDirect() 方法分配直接缓冲区，将缓冲区建立在计算机直接物理内存中。某种情况下，可以提高效率
 * @Version: 1.0
 */
public class TestBuffer {

    @Test
    public void test3(){
        //分配直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        //判断是否为直接缓冲区
        System.out.println(byteBuffer.isDirect());
    }

    @Test
    public void test2(){
        String str = "qwert";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.put(str.getBytes());

        byteBuffer.flip();

        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes,0,2);
        System.out.println(new String(bytes, 0, 2));

        System.out.println(byteBuffer.position());

        //mark()：标记
        byteBuffer.mark();
        byteBuffer.get(bytes,2,2);
        System.out.println(new String(bytes, 2, 2));
        System.out.println(byteBuffer.position());

        //reset()：恢复到mark的位置
        byteBuffer.reset();
        System.out.println(byteBuffer.position());

        //判断缓冲区中是否还有剩余数据
        if (byteBuffer.hasRemaining()){
            //获取缓冲区可以操作的数量
            System.out.println(byteBuffer.remaining());
        }
    }

    @Test
    public void test1(){

        String str = "abcde";

        //1.利用allocate()分配一个指定大小的缓冲区
        System.out.println("---------------allocate()-------------------");
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //2.利用put()存入数据到缓冲区中去
        System.out.println("---------------put()-------------------");
        byteBuffer.put(str.getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //3、利用flip()切换读取数据的模式
        System.out.println("---------------flip()-------------------");
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        //System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));

        //4、利用get()读取缓冲区中的数据
        System.out.println("---------------get()-------------------");
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes,0,bytes.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //5、rewind：可重复读数据
        System.out.println("---------------rewind()-------------------");
        byteBuffer.rewind();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        //再次从缓冲区读取数据，依然可以读到
        System.out.println("-----再次从缓冲区读取数据，依然可以读到-----");
        byte[] bytes1 = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes1);
        System.out.println(new String(bytes1,0,bytes1.length));
        //6、clear()：清空缓冲区,但是缓冲区中的数据依然存在，但是处于“被遗忘”状态
        System.out.println("---------------clear()-------------------");
        byteBuffer.clear();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        byte[] byte2 = new byte[4];
        byteBuffer.get(byte2);
        System.out.println(new String(byte2,0,byte2.length));
    }
}
