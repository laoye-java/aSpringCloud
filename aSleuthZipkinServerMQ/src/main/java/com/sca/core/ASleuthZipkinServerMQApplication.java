package com.sca.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
//@EnableZipkinServer  //改为使用Stream方式启动ZipkinServer
@EnableZipkinStreamServer //使用Stream方式启动ZipkinServer
public class ASleuthZipkinServerMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(ASleuthZipkinServerMQApplication.class,args);
    }
}

