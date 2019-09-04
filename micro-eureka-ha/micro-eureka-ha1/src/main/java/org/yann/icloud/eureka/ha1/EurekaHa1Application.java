package org.yann.icloud.eureka.ha1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaHa1Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaHa1Application.class, args);
    }
}
