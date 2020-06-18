package com.example.demo.test.testSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 作者 lqq
 * @ClassName 类名 SocketServerM
 * @date 2020/4/7 16:50
 * @注释：
 */
public class SocketServerM {
    public static void main(String[] args) throws IOException {

        int port = 7000;
        int clientNo = 1;

        ServerSocket serverSocket = new ServerSocket(port);

        // 创建线程池
        ExecutorService exec = Executors.newCachedThreadPool();

        try {

            while (true) {
                Socket socket = serverSocket.accept();
                exec.execute(new SingleServer(socket, clientNo));
                clientNo++;
            }

        } finally {
            serverSocket.close();
        }

    }
}

class SingleServer implements Runnable {

    private Socket socket;
    private int clientNo;
    private DataInputStream dis;
    private DataOutputStream dos;
    public SingleServer(Socket socket, int clientNo) {
        this.socket = socket;
        this.clientNo = clientNo;
        try {
            this.dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            this.dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            do {
                double length = dis.readDouble();
                System.out.println("从客户端" + clientNo + "接收到的边长数据为：" + length);
                double result = length * length;
                dos.writeDouble(result);
                dos.flush();
            } while (dis.readInt() != 0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("与客户端" + clientNo + "通信结束");
            try {
                dis.close();
                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
