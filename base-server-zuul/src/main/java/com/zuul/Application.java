package com.zuul;

import com.zuul.fliter.ErrorFilter;
import com.zuul.fliter.PostFilter;
import com.zuul.fliter.PreFilter;
import com.zuul.fliter.RoutingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by mao_yejun on 2016/10/21.
 */
@EntityScan("com.zuul.entity")
@EnableJpaRepositories(basePackages="com.zuul.repository")
@EnableZuulProxy
@EnableEurekaClient
@SpringCloudApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public RoutingFilter routingFilter() {
        return new RoutingFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}
