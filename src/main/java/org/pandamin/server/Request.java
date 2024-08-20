package org.pandamin.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Request {

    private final InputStreamReader isr;

    public Request(InputStreamReader isr) {
        this.isr = isr;
    }

    public String getRequestMessage() throws IOException {
        BufferedReader br = new BufferedReader(isr);

        StringBuilder request = new StringBuilder();
        String line = br.readLine();

        while (!line.isBlank()) {
            request.append(line).append("\r\n");
            line = br.readLine();
        }

        return request.toString();
    }

    public String getPath() throws IOException {
        String requestMessage = this.getRequestMessage();

        // Get the first line of the HTTP request
        String line = Arrays.toString(requestMessage.split("\n", 0));
        // Extract and return the path from the first line of the HTTP request
        return line.split(" ")[1];
    }
}
