package org.yann.icloud.movie.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MovieHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieHystrixDashboardApplication.class, args);
    }

}
