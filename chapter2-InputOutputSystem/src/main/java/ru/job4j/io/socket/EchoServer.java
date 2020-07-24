package ru.job4j.io.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    @SuppressWarnings("checkstyle:InnerAssignment")
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Bye")) {
                            System.out.println("closing");
                            socket.close();
                            break;
                        }
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
