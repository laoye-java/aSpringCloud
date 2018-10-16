package com.sca.core;

import com.sca.core.zuul.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class AZuulGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(AZuulGateWayApplication.class,args);
    }

    //@Bean将过滤器交给Spring管理
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
}

