package com.ly.springBoot.action.mq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/7/16 19:49
 */
@Component
@RabbitListener(queues = {"spring-queue-topic"})
public class TopicReceiver {
    //此方法参数需跟发送消息的参数类型一致
    @RabbitHandler
    public void handler(String msg){
        System.out.println("接受到消息:"+msg);
    }
}
