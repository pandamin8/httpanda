package org.pandamin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Router {

    private final Map<String, BiConsumer<Request, Response>> routes;

    public Router() {
        routes = new HashMap<>();
    }

    public void addRoute(String path, BiConsumer<Request, Response> handler) {
        routes.put(path, handler);
    }

    public BiConsumer<Request, Response> getHandler(String path) {
        return routes.getOrDefault(path, this::notFoundHandler);
    }

    private void notFoundHandler(Request request, Response response) {
        try {
            response.sendMessage("Page Not Found", StatusCode.NOT_FOUND_404);
        } catch (IOException e) {
            throw new RuntimeException("io exception");
        }
    }
}
