package com.twobored2queue.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LocalServer {
    private final int port;

    public LocalServer(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("[Server] Listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("[Server] Connection accepted from " + clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket)).start();
            }

        } catch (IOException e) {
            System.err.println("[Server] Error: " + e.getMessage());
        }
    }
}
