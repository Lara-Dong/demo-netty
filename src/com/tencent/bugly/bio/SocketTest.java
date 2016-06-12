package com.tencent.bugly.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Blocking I/O Example
 */
public class SocketTest {

    private static String processRequest(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        int portNumber = 80;
        //1 ServerSocket 创建并监听端口的连接请求
        ServerSocket serverSocket = new ServerSocket(portNumber);
        //2 accept() 调用阻塞，直到一个连接被建立了。返回一个新的 Socket 用来处理 客户端和服务端的交互
        Socket clientSocket = serverSocket.accept();
        //3 流被创建用于处理 socket 的输入和输出数据。BufferedReader 读取从字符输入流里面的本文。PrintWriter 打印格式化展示的对象读到本文输出流
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
        String request, response;
        //4 处理循环开始 readLine() 阻塞，读取字符串直到最后是换行或者输入终止。
        while ((request = in.readLine()) != null) {
            //5 如果客户端发送的是“Done”处理循环退出
            if ("Done".equals(request)) {
                break;
            }
        }
        //6 执行方法处理请求，返回服务器的响应
        response = processRequest(request);
        //7 响应发回客户端
        out.println(response);
    }
}