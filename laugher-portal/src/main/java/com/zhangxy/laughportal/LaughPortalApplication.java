package com.zhangxy.laughportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LaughPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaughPortalApplication.class, args);
    }

}
