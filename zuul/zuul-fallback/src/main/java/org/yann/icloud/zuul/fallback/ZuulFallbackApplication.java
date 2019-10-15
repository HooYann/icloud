package org.yann.icloud.zuul.fallback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulFallbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulFallbackApplication.class, args);
    }

}
