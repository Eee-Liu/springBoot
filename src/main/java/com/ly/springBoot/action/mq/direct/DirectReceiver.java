package com.ly.springBoot.action.mq.direct;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/7/13 18:05
 */
@Component
@RabbitListener(queues = {"spring-queue-direct"})
public class DirectReceiver{
    /**
     * RabbitMQ消息处理方法，该方法的参数要与rabbitmq-provider发送消息时的类型保持一致，
     * 否则无法自动调用消费方法，也就无法完成消息的消费。
     * @param
     */
    @RabbitHandler
    public void execute(Map<String, Object> log)
    {
        System.out.println("收到消息:用户:" + log+"，完成了注册");

        //...//自行业务逻辑处理
    }

}
