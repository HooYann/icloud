package org.yann.icloud.movie.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "micro-user")
public interface UserFeignClient {

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") Long id);

}
