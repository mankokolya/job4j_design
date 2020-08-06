package ru.job4j.io.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        boolean serverWork = true;
        final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

        try (ServerSocket server = new ServerSocket(9000)) {
            while (serverWork) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                    while (!str.isEmpty()) {
                        if (str.contains("Bye")) {
                            out.write("closing server\r\n".getBytes());
                            serverWork = false;
                            break;
                        }
                        if (str.contains("Hello")) {
                            out.write("Hello dear friend\r\n".getBytes());
                        } else {
                            if (str.contains("msg")) {
                                String[] splitMsg = str.split(" ");
                                String message = splitMsg[1].split("=")[1] + System.lineSeparator();
                                out.write(message.getBytes());
                            }
                        }
                        str = in.readLine();
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in ", e);
        }
    }
}
