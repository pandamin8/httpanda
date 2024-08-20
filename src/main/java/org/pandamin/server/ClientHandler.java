package org.pandamin.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket client;
    private final Router router;

    public ClientHandler(Socket client, Router router) {
        this.client = client;
        this.router = router;
    }

    @Override
    public void run() {
        try (InputStreamReader isr = new InputStreamReader(client.getInputStream())) {

            OutputStream outputStream = client.getOutputStream();

            Request request = new Request(isr);
            String path = request.getPath();

            Response response = new Response(outputStream);

            router.getHandler(path).accept(request, response);
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
