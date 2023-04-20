package com.sharingsugar.centraldatabaseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CentralDataBaseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CentralDataBaseServiceApplication.class, args);
    }

}
