package org.pandamin;

import org.pandamin.server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server(8080, 8);

        server.router.get("/hello", (req, res) -> {
            try {
                res.sendMessage("hello world");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        server.router.post("/hello", (req, res) -> {
            try {
                res.sendMessage("hello world");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        server.router.patch("/hello", (req, res) -> {
            try {
                res.sendMessage("hello world");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        server.router.delete("/hello", (req, res) -> {
            try {
                res.sendMessage("hello world");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        server.listen();
    }
}