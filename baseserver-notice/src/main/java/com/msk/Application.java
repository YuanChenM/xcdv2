package com.msk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by mao_yejun on 2016/10/11.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
public class Application {
    public static void  main (String[] args){
        SpringApplication.run(Application.class,args);
    }

}
