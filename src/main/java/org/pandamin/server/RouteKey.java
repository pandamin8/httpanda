package org.pandamin.server;

public class RouteKey {
    private final String uri;
    private final HttpMethod method;
    private int hashCode;

    public RouteKey(String uri, HttpMethod method) {
        this.uri = uri;
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RouteKey that = (RouteKey) o;
        return uri.equals(that.uri) && method == that.method;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
