package com.example;

import java.io.*;
import java.net.Socket;

/**
 * Client player that initiates the message communication.
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            int count = 0;
            String response;

            System.out.println("Client started communication...");
            out.println("Hello from Client");

            while ((response = in.readLine()) != null && count < 10) {
                System.out.println("Client received: " + response);
                count++;
                out.println("Reply " + count);
            }

            System.out.println("Client shutting down.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
