package com.ly.springBoot.congif;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: LiuYi
 * @Description: topic模式消息队列配置
 * @Date: Created in 2018/7/16 19:36
 */
@Configuration
public class TopicQueueConfiguration {
    @Bean
    public TopicExchange createTopicExchange() {
        return new TopicExchange("spring-exchange-topic", true, false);
    }

    @Bean
    public Queue createQueue() {
        return new Queue("spring-queue-topic", true);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(createQueue()).to(createTopicExchange()).with("topic.#");
    }
}
