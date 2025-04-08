package com.example;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ServerTest {

    @Test
    void testServerReceivesAndReplies() throws IOException, InterruptedException {
        // Create a thread pool to run the server and client in parallel
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Run the server in a separate thread
        executor.submit(() -> {
            Server.main(new String[]{}); // Start server
        });

        // Give the server some time to start
        Thread.sleep(500);

        // Mock client that connects to the server and sends a message
        executor.submit(() -> {
            try (Socket clientSocket = new Socket("localhost", 5000);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                // Send message to server
                out.println("Hello from Test Client");

                // Read server response
                String response = in.readLine();
                System.out.println("Test Client received: " + response);

                assertTrue(response.contains("Reply to")); // Check if server responded
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Wait for tasks to complete
        Thread.sleep(2000);
        executor.shutdown();
    }
}
