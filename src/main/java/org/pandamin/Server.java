package org.pandamin;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    int port;

    public Server(int port) {
        this.port = port;
    }

    public void listen() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("server is up on port: " + port);

            while (true) {
                try (Socket client = serverSocket.accept()) {
                    InputStreamReader isr = new InputStreamReader(client.getInputStream());
                    Request request = new Request(isr);
                    String requestMessage = request.getRequestMessage();

                    OutputStream outputStream = client.getOutputStream();
                    Response response = new Response(outputStream);
                    response.sendMessage("HTTP/1.1 200 OK\r\n\r\nHello World");
                }
            }
        }
    }
}
