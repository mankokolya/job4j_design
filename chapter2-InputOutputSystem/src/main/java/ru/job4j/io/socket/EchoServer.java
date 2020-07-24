package ru.job4j.io.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        boolean serverWork = true;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (serverWork) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Bye")) {
                            out.write("closing server\r\n".getBytes());
                            serverWork = false;
                            break;
                        }
                        if (str.contains("Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                        }
                        str = in.readLine();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
