package org.yann.icloud.movie.feign.manual;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient 不需要
public interface UserFeignClient {

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id);

}
