package com.sparta.sp_week01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class SpWeek01Application {
    public static void main(String[] args) {
        SpringApplication.run(SpWeek01Application.class, args);
    }
}
