package com.sca.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class MQ {
    public static void main(String[] args) {
        SpringApplication.run(MQ.class,args);
    }
}

