package com.example.projeto_spring_mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.projeto_spring_mongo", "resources", "service", "config", "exception"})
@EnableMongoRepositories(basePackages = "repository")
public class ProjetoSpringMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoSpringMongoApplication.class, args);
    }

}
