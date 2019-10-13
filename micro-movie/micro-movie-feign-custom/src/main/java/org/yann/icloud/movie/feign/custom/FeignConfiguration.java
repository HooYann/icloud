package org.yann.icloud.movie.feign.custom;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 该类不可写@Configuration注解，写了，就不能放在主应用程序上下文@ComponentScan扫描的包中
 */
public class FeignConfiguration {

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
