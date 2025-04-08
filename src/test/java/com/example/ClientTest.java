package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import static org.mockito.Mockito.*;

class ClientTest {
    @Test
    void testClientCommunication() throws IOException {
        // Mock ServerSocket and Socket
        ServerSocket mockServerSocket = Mockito.mock(ServerSocket.class);
        Socket mockSocket = Mockito.mock(Socket.class);
        BufferedReader mockReader = Mockito.mock(BufferedReader.class);
        PrintWriter mockWriter = Mockito.mock(PrintWriter.class);

        // Mock behavior
        when(mockServerSocket.accept()).thenReturn(mockSocket);
        when(mockSocket.getInputStream()).thenReturn(new ByteArrayInputStream("Reply 1\n".getBytes()));
        when(mockSocket.getOutputStream()).thenReturn(new ByteArrayOutputStream());
        when(mockReader.readLine()).thenReturn("Reply 1", "Reply 2", null);

    }
}
