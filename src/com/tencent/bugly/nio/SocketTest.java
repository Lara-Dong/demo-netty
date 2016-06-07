package com.tencent.bugly.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by laradong on 2016/6/7.
 */
public class SocketTest {

    private static String processRequest(String request) {

    }

    public static void main(String[] args) {
        int portNumber = 80;
        ServerSocket serverSocket = new ServerSocket(portNumber);//1
        Socket clientSocket = serverSocket.accept();             //2
        BufferedReader in = new BufferedReader(                     //3
                new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
        String request, response;
        while ((request = in.readLine()) != null) {                 //4
            if ("Done".equals(request)) {                         //5
                break;
            }
        }
        response = processRequest(request);                        //6
        out.println(response);
    }
}
