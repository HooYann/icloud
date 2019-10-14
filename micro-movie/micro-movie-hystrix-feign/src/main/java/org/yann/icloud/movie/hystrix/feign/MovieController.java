package org.yann.icloud.movie.hystrix.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping(value = "/user/{id}")
    public User findUserById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

}
