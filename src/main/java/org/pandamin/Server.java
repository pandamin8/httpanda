package org.pandamin;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class Server {
    int port;
    private final ExecutorService executorService;
    public final Router router;

    public Server(int port, int threadPoolSize) {
        this.port = port;
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
        this.router = new Router();
    }

    public void listen() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("server is up on port: " + port);

            while (true) {
                Socket client = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(client, router);
                executorService.submit(clientHandler);
            }
        } finally {
            if (executorService != null && !executorService.isShutdown())
                executorService.shutdown();
        }
    }
}
