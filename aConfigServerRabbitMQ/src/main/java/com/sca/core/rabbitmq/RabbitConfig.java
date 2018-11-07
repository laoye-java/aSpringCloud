package com.sca.core.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 *  RabbitMQ的配置类，用来配队列、交换器、路由等高级信息
 */
public class RabbitConfig {
    @Bean
    public Queue helloConfig(){
        return new Queue("hello");
    }
}
