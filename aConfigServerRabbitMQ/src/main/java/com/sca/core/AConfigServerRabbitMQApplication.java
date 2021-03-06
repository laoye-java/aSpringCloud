package com.sca.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer  //配置中心
@EnableEurekaClient  //向服务中心注册,使用Eureka
public class AConfigServerRabbitMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(AConfigServerRabbitMQApplication.class,args);
    }
}

