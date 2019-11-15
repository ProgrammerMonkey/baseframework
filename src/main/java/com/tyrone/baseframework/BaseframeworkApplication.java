package com.tyrone.baseframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.tyrone.baseframework")
public class BaseframeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseframeworkApplication.class, args);
    }

}
