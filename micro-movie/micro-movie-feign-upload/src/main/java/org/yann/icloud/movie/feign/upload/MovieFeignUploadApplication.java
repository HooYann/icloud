package org.yann.icloud.movie.feign.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieFeignUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieFeignUploadApplication.class, args);
    }

}
