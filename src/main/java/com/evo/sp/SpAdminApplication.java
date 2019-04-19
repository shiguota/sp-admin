package com.evo.sp;

import com.terran4j.commons.api2doc.config.EnableApi2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
@EnableApi2Doc
@MapperScan("com.evo.sp.**.mapper")
public class SpAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpAdminApplication.class, args);
    }
}
