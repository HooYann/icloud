package org.yann.icloud.movie.feign.custom;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "micro-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    /**
     * 改成 Feign 自带的注解：Feign.RequestLine, Feign.Param
     */

    //@GetMapping(value = "/{id}")
    @RequestLine("GET /{id}")
    //public User findById(@PathVariable("id") Long id);
    public User findById(@Param("id") Long id);

}
