package org.yann.icloud.movie.hystrix.feign.fallback.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieHystrixFeignFallbackFactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieHystrixFeignFallbackFactoryApplication.class, args);
    }

}
