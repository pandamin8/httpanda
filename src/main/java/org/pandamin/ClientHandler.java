package org.pandamin;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (InputStreamReader isr = new InputStreamReader(client.getInputStream())) {

            OutputStream outputStream = client.getOutputStream();

            Request request = new Request(isr);
            Response response = new Response(outputStream);
            response.sendMessage("HTTP/1.1 200 OK\r\n\r\nHello World");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
