package com.example.demo.test.testSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 作者 lqq
 * @ClassName 类名 ScoketServer
 * @date 2020/4/7 13:51
 * @注释：
 */
public class ScoketServer {
    public static void main(String[] args) throws IOException {

        // 端口号
        int port = 7000;
        // 在端口上创建一个服务器套接字
        ServerSocket serverSocket = new ServerSocket(port);
        // 监听来自客户端的连接
        while(true){
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));
            do {
                double length = dis.readDouble();
                System.out.println("服务器端收到的边长数据为：" + length);
                double result = length * length;
                dos.writeDouble(result);
                dos.flush();
            } while (dis.readInt() != 0);

            socket.close();
        }
//        serverSocket.close();
    }
}
