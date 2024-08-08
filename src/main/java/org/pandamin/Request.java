package org.pandamin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Request {

    InputStreamReader isr;

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
}
