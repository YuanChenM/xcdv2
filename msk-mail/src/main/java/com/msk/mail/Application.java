package com.msk.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by jackjiang on 16/7/11.
 */
@EnableEurekaClient
@SpringBootApplication
public class Application {
    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }
}
