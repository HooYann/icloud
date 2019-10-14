package org.yann.icloud.movie.hystrix.feign.fallback.factory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "micro-user", fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping("/{id}")
    User findById(@PathVariable Long id);

}
