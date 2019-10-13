package org.yann.icloud.movie.feign.custom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieFeignCustomApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieFeignCustomApplication.class, args);
    }

}
