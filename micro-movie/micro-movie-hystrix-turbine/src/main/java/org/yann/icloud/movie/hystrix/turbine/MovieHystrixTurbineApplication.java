package org.yann.icloud.movie.hystrix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class MovieHystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieHystrixTurbineApplication.class, args);
    }

}
