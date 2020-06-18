package com.example.demo.test.testIO;


import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * @author 作者 lqq
 * @ClassName 类名 Test
 * @date 2020/5/29 14:57
 * @注释：
 */
public class TestIO {

    @Test
    public void test2(){
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }
    public static void main(String[] args) throws IOException {
        test();
    }


    public static void test() throws IOException {
        File file1 = new File("F:\\text.txt");
        FileReader fileReader = new FileReader(file1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line).append("\n");
        }
        System.out.println(stringBuilder.toString());
        fileReader.close();
        bufferedReader.close();
    }

    public static void test1() throws IOException {
        File file1 = new File("F:\\text.txt");
        InputStream inputStream = new FileInputStream(file1);
        OutputStream  outputStream = new ByteArrayOutputStream();
        int a;
        byte[] buffer = new byte[2048];
        while ((a = inputStream.read(buffer)) != -1){
            outputStream.write(buffer,0,a);
        }
        System.out.println(new String(((ByteArrayOutputStream) outputStream).toByteArray()));
        outputStream.close();
        inputStream.close();
    }

}
