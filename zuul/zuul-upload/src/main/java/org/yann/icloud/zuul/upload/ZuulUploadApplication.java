package org.yann.icloud.zuul.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//@EnableZuulProxy
@EnableEurekaClient
public class ZuulUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulUploadApplication.class, args);
    }

}
