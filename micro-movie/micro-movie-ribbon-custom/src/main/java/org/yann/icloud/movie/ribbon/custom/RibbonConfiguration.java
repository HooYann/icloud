package org.yann.icloud.movie.ribbon.custom;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 不能存放在主应用程序上下文的@ComponentScan所扫描的包中
 * 或者 注释 @Configuration
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
