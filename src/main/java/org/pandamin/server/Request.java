package org.pandamin.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Request {

    private final InputStreamReader isr;
    private final String firstLine;

    public Request(InputStreamReader isr) throws IOException {
        this.isr = isr;
        this.firstLine = this.getTheFirstLine();
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

    private String getTheFirstLine() throws IOException {
        String requestMessage = this.getRequestMessage();
        return requestMessage.split("\n", 0)[0];
    }

    public String getUri() {
        // Extract and return the uri from the first line of the HTTP request
        return this.firstLine.split(" ")[1];
    }

    public HttpMethod getMethod() {
        String strMethod = firstLine.split(" ")[0].toLowerCase();

        HttpMethod method;

        switch (strMethod) {
            case "get":
                method = HttpMethod.GET;
                break;
            case "post":
                method = HttpMethod.POST;
                break;
            case "delete":
                method = HttpMethod.DELETE;
                break;
            case "patch":
                method = HttpMethod.PATCH;
                break;
            default:
                method = HttpMethod.UNSUPPORTED;
        }

        return method;
    }
}
