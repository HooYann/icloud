package org.yann.icloud.movie.hystrix.feign.fallback.factory;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {

    private Long id;

    private String username;

    private String name;

    private Integer age;

    private BigDecimal balance;

}
