package org.xhy.socket.client;

import org.xhy.socket.MyObject;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-06 23:55
 */
public class Client {
    static String hostName = "localhost"; // 服务端的主机名或IP地址
    static int port = 12345; // 服务端监听的端口

    public static void main(String[] args) throws IOException {
        runWithObject();
    }


    public static void run()throws IOException {

        Socket socket = new Socket(hostName, port);
        System.out.println("Connected to server at " + hostName + ":" + port);

        OutputStream outToServer = socket.getOutputStream();
        PrintWriter out = new PrintWriter(outToServer, true);
        String messageToSend = "Hello, Server xhy!";
        out.println(messageToSend);

        socket.close();
        System.out.println("发送完毕");
    }

    // 粘包问题
    public static void runWithStickyBag() throws IOException {


        Socket socket = new Socket(hostName, port);
        System.out.println("Connected to server at " + hostName + ":" + port);

        OutputStream outToServer = socket.getOutputStream();

        // 发送多个小消息，模拟粘包和半包问题
        String[] messages = {"Hello,", "Server!", "How", "are", "you?"};
        for (String message : messages) {
            outToServer.write(message.getBytes());
            outToServer.flush(); // 确保立即发送
        }

        socket.close();
    }



    // 解决粘包
    public static void resolveRunWithStickyBag() throws IOException {

        Socket socket = new Socket(hostName, port);
        System.out.println("Connected to server at " + hostName + ":" + port);

        DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

        // 发送多个小消息，使用消息头和消息体避免粘包和半包
        String[] messages = {"Hello,", "Server!", "How", "are", "you?"};
        for (String message : messages) {
            outToServer.writeInt(message.length()); // 发送消息长度
            outToServer.writeBytes(message); // 发送消息
            outToServer.flush(); // 确保立即发送
        }

        socket.close();
    }

    // 半包问题
    public static void runWithHalfPackage() throws IOException {
        Socket socket = new Socket(hostName, port);
        System.out.println("Connected to server at " + hostName + ":" + port);

        OutputStream outToServer = socket.getOutputStream();
        PrintWriter out = new PrintWriter(outToServer, true);

        // 发送一个长消息，模拟半包问题
        String longMessage = "This is a very long message that will be split into two parts to simulate a half package issue.";
        out.println(longMessage);

        socket.close();
    }

    public static void runWithObject() throws IOException {
        Socket socket = new Socket(hostName, port);
        System.out.println("Connected to server at " + hostName + ":" + port);

        // 创建要发送的对象
        MyObject myObject = new MyObject("Hello", "World");

        // 使用对象输出流发送对象
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(myObject);

        out.close();
        socket.close();
    }
}
