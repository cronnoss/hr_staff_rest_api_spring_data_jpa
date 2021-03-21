package com.cronnoss.hr_staff_rest_api_spring_data_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class HrStaffRestApiSpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrStaffRestApiSpringDataJpaApplication.class, args);
    }

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}