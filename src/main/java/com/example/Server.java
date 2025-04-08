package com.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server player that waits for messages and responds to the client.
 */
public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started, waiting for connection...");

            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                System.out.println("Client connected.");

                int count = 0;
                String receivedMessage;

                while ((receivedMessage = in.readLine()) != null && count < 10) {
                    System.out.println("Server received: " + receivedMessage);
                    count++;
                    out.println("Reply " + count);
                }

                System.out.println("Server shutting down.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
