package com.evo.sp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.evo.sp.**.mapper")
public class SpAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpAdminApplication.class, args);
    }

}
