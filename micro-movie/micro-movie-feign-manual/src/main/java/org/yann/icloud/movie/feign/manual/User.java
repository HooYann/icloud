package org.yann.icloud.movie.feign.manual;

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
