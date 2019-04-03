package com.spring.jianyue.api;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.spring.jianyue.api.mapper")
@SpringBootApplication
@EnableSwagger2Doc
public class JianyueApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JianyueApiApplication.class, args);
    }

}
