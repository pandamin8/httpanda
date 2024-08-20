package org.pandamin;

import org.pandamin.server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server(8080, 8);

        server.router.addRoute("/hello", (request, response) -> {
            try {
                response.sendMessage("hello world");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        server.router.addRoute("/goodbye", (request, response) -> {
            try {
                response.sendMessage("goodbye world");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        server.listen();
    }
}