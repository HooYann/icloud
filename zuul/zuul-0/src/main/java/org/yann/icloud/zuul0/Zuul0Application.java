package org.yann.icloud.zuul0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul0Application {

    public static void main(String[] args) {
        SpringApplication.run(Zuul0Application.class, args);
    }

}
