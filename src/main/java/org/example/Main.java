package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApiController apiController = new ApiController();
        apiController.chamarAPI("10");
    }
}