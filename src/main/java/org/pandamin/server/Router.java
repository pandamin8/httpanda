package org.pandamin.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Router {

    private final Map<RouteKey, BiConsumer<Request, Response>> routes;

    Router() {
        routes = new HashMap<>();
    }

    public void get(String uri, BiConsumer<Request, Response> handler) {
        RouteKey routeKey = new RouteKey(uri, HttpMethod.GET);
        routes.put(routeKey, handler);
    }

    public void post(String uri, BiConsumer<Request, Response> handler) {
        RouteKey routeKey = new RouteKey(uri, HttpMethod.POST);
        routes.put(routeKey, handler);
    }

    public void patch(String uri, BiConsumer<Request, Response> handler) {
        RouteKey routeKey = new RouteKey(uri, HttpMethod.PATCH);
        routes.put(routeKey, handler);
    }

    public void delete(String uri, BiConsumer<Request, Response> handler) {
        RouteKey routeKey = new RouteKey(uri, HttpMethod.DELETE);
        routes.put(routeKey, handler);
    }

    BiConsumer<Request, Response> getHandler(RouteKey route) {
        return routes.getOrDefault(route, this::notFoundHandler);
    }

    private void notFoundHandler(Request request, Response response) {
        try {
            response.sendMessage("Page Not Found", StatusCode.NOT_FOUND_404);
        } catch (IOException e) {
            throw new RuntimeException("io exception");
        }
    }
}
