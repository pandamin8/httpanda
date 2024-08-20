# 🐼 HTTPanda

An HTTP server as fast 

> *This package is still under construction*


## 🌟 Highlights

- An HTTP server made from scratch
- This problem handled
- etc.


## ℹ️ Overview

As a refresher for Java programming language I decided to make an HTTP server from scratch to enhance my Java programming experience and learn more about HTTP servers, Java concurrency, and lambda expressions.

For now this package only supports GET method. But other methods will be added eventually.

## ⬇️ Installation

This package hasn't been published yet on any Java package repository. 

Be sure to have JDK 7 installed.

## 🚀 Usage

*Setup the server by creating the server object and set the port number and the number of threads you want your server to work with. Then, implement the REST endpoints "aka routes".*

First setup the server
```java
Server server = new Server(portNumber, numberOfThreads);
```

This is how you can implement a GET route with the ```router.get``` method and pass the URI and a lambda function as parameters. 
```java
server.router.get("/hello", (req, res) -> {
try {
    res.sendMessage("hello world");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
});
```

The Router class has the following methods for setting up endpoints.

| Method                                                                                          |
|:------------------------------------------------------------------------------------------------|
| ``get(String uri, BiConsumer<Request, Response> handler)``<br/>*Implement a GET endpoint*       |
| ``post(String uri, BiConsumer<Request, Response> handler)``<br/>*Implement a POST endpoint*     |
| ``patch(String uri, BiConsumer<Request, Response> handler)``<br/>*Implement a PATCH endpoint*   |
| ``delete(String uri, BiConsumer<Request, Response> handler)``<br/>*Implement a DELETE endpoint* |


## 📝 TODO list
* Add other HTTP methods (GET, POST, DELETE, and UPDATE are added but there are more methods).
* Add support for HTTP headers.
* Make the server to be able to serve static files.
* 

## 🎍 Feedback and Contributing

If you are interested in this project and want to share your ideas you can discuss [here](https://github.com/pandamin8/httpanda/discussions).

A contributing guide has not been made yet but feel free to contribute, [post issues](https://github.com/pandamin8/httpanda/issues), and give this hungry panda some fresh bamboo.

![image](https://github.com/user-attachments/assets/d359283d-62df-4cdd-b565-74a6a1e6adfe)
