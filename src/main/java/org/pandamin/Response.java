package org.pandamin;

import java.io.IOException;
import java.io.OutputStream;

public class Response {
    private final OutputStream outputStream;

    public String body;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void sendMessage(String body, String status) throws IOException {
        String message = this.generateMessage(body, status);
        sendResponse(message);
    }

    public void sendMessage(String body) throws IOException {
        String message = this.generateMessage(body, StatusCode.OK_200);
        sendResponse(message);
    }

    private void sendResponse(String message) throws IOException {
        outputStream.write((message).getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private String generateMessage(String body, String status) {
        return "HTTP/1.0 " + status + "\r\n\r\n" + body;
    }
}
