package com.baseserver.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by shi_yuxi on 2016/11/8.
 */
@SpringBootApplication
@EnableConfigurationProperties
@EnableEurekaClient
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
