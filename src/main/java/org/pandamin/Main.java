package org.pandamin;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server(8080, 8);
        server.listen();
    }
}