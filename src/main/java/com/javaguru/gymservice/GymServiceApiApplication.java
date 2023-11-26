package com.javaguru.gymservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableCaching
@SpringBootApplication
public class GymServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymServiceApiApplication.class, args);
    }

}
