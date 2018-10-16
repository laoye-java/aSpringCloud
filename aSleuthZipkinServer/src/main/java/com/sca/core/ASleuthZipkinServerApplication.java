package com.sca.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ASleuthZipkinServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ASleuthZipkinServerApplication.class,args);
    }
}

