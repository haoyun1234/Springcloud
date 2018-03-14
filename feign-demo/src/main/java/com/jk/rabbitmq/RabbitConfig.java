package com.jk.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {
    /**
     * 创建短信消息队列
     */
    @Bean
    public Queue queue(){
        return  new Queue("sms");

    }
}
