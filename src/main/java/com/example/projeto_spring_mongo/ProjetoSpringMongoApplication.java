package com.example.projeto_spring_mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.projeto_spring_mongo", "resources"})
public class ProjetoSpringMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoSpringMongoApplication.class, args);
    }

}
