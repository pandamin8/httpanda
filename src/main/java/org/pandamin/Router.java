package org.pandamin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Router {

    private final Map<String, Consumer<Response>> routes;

    public Router() {
        routes = new HashMap<>();
    }

    public void addRoute(String path, Consumer<Response> handler) {
        routes.put(path, handler);
    }

    public Consumer<Response> getHandler(String path) {
        return routes.getOrDefault(path, this::notFoundHandler);
    }

    private void notFoundHandler(Response response) {
        try {
            response.sendMessage("Page Not Found", StatusCode.NOT_FOUND_404);
        } catch (IOException e) {
            throw new RuntimeException("io exception");
        }
    }
}
