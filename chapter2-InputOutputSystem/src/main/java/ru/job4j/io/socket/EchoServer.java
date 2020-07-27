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
                        if (str.contains("Bye")) {
                            out.write("closing server\r\n".getBytes());
                            serverWork = false;
                            break;
                        }
                        if (str.contains("Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                            out.write("Hello dear friend\r\n".getBytes());
                        } else {
                            if (str.contains("msg")) {
                                String[] splitMsg = str.split(" ");
                                String message = splitMsg[1].split("=")[1] + System.lineSeparator();
                                System.out.println(message);
                                out.write(message.getBytes());
                            }
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
