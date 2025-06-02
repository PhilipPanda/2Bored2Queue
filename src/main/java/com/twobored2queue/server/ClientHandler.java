package com.twobored2queue.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream in = socket.getInputStream(); OutputStream out = socket.getOutputStream()) {
            System.out.println("[Server] Handling connection from " + socket.getInetAddress());

            out.write("Hello from 2Bored2Queue local server!\n".getBytes());
            out.flush();

        } catch (IOException e) {
            System.err.println("[Server] Client error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {}
        }
    }
}
