package org.yann.icloud.movie.ribbon.custom;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RibbonConfiguration2 {

    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }

}

