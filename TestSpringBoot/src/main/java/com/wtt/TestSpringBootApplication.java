package com.wtt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wtt.mapper")
public class TestSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestSpringBootApplication.class,args);

    }
}
