package com.example.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class CounterApplication {
    private static int counter = 0;
    Logger logger = LoggerFactory.getLogger(CounterApplication.class);

    @PostMapping("/counter")
    @ResponseBody
    ResponseEntity<String> counter(HttpEntity<String> httpEntity) {
        counter++;
        String response = String.format("Request number: %s.\nRequest body: \n'%s' ", counter, httpEntity.getBody());
        logger.info(response);
        return ResponseEntity
                .internalServerError()
                .body(response);
    }

    public static void main(String[] args) {
        SpringApplication.run(CounterApplication.class, args);
    }

}
