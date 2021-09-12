package com.synthesize;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.synthesize.mapper"})
@SpringBootApplication
public class SynthesizeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SynthesizeApplication.class, args);
    }

}
