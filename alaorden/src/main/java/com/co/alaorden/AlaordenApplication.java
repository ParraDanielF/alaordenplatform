package com.co.alaorden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
public class AlaordenApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlaordenApplication.class, args);
    }

}
