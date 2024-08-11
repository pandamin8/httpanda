# 🐼 HTTPanda

An http server as fast 

> *This package is still under construction*


## 🌟 Highlights

- An HTTP server made from scratch
- This problem handled
- etc.


## ℹ️ Overview

As a refresher for Java programming language I decided to make an HTTP server from scratch to enhance my Java programming experience and learn more about HTTP servers, Java concurrency, and lambda expressions.

For now this package only supports GET method. But other methods will be added eventually.

## 🚀 Usage

*Show off what your software looks like in action! Try to limit it to one-liners if possible and don't delve into API specifics.*

```java
Server server = new Server(portNumber, numberOfThreads);
server.router.addRoute("/hello", response -> {
try {
    response.sendMessage("hello world");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
});
```


## ⬇️ Installation

This package hasn't been published yet on any Java package repository. 

Be sure to have JDK 7 installed.

## 📝 TODO list
* Add other HTTP methods.
* Add support for HTTP headers.
* Make the server to be able to serve static files.

## 🎍 Feedback and Contributing

If you are interested in this project and want to share your ideas you can discuss [here](https://github.com/pandamin8/httpanda/discussions).

A contributing guide has not been made yet but feel free to contribute and [post issues](https://github.com/pandamin8/httpanda/issues) and give this hungry panda some fresh bamboo.