package org.yann.icloud.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/movie/go_to_with_who")
    public User findUser(@RequestParam Long id) {
        User u = restTemplate.getForObject("http://localhost:18000/" + id, User.class);
        return u;
    }

}
