package org.pandamin;

import java.io.IOException;
import java.io.OutputStream;

public class Response {
    OutputStream outputStream;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void sendMessage(String message) throws IOException {
        outputStream.write((message).getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
