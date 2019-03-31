package com.evo.sp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.evo.sp.basis.mapper")
public class SpAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpAdminApplication.class, args);
    }

}
