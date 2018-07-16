package com.ly.springBoot.congif;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: LiuYi
 * @Description: 直连接队列配置
 * @Date: Created in 2018/7/16 14:06
 */
@Configuration
public class DirectQueueConfiguration {

    /**
     * 声明交换机
     * @return
     */
    @Bean
    public DirectExchange registerDirectExchange(){
        String EXCHANGE_NAME = "spring-exchange-direct";
        return new DirectExchange(EXCHANGE_NAME);
    }

    /**
     * 声明队列,并设置为持久化队列
     * @return
     */
    @Bean
    public Queue registerQueue(){
       return new Queue("spring-queue-direct",true);
    }

    /**
     * 将用户注册队列绑定到路由交换配置上并设置指定路由键进行转发
     * @return
     */
    @Bean
    public Binding registerBinding(){
        return BindingBuilder.bind(registerQueue()).to(registerDirectExchange()).with("spring-direct");
    }
}
