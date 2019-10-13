package org.yann.icloud.movie.ribbon.custom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
/**
 * here ******
 */
//@RibbonClient(name = "micro-user")
/**
 * here ******
 */
public class MovieController2 {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user2/{id}")
    public User findById(@PathVariable Long id) {
        //return this.restTemplate.getForObject("http://localhost:18010/" + id, User.class);
        return this.restTemplate.getForObject("http://micro-user/" + id, User.class);
    }

}
