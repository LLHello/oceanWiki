package com.gec.oceanbioproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan("com.gec.oceanbioproject.mapper")
@SpringBootApplication
public class OceanBioProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(OceanBioProjectApplication.class, args);
    }

}
