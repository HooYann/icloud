package org.yann.icloud.movie.hystrix.feign.fallback.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return this.userFeignClient.findById(id);
    }

}
