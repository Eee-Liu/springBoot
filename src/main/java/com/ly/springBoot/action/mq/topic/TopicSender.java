package com.ly.springBoot.action.mq.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

/**
 * @Author: LiuYi
 * @Description: topic模式消息发送者
 * @Date: Created in 2018/7/16 19:43
 */
@Controller
@RequestMapping("/sendMsg")
public class TopicSender implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/topic.do")
    public void sendMsg(){
        //设置回调为当前类对象
        rabbitTemplate.setConfirmCallback(this);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("spring-exchange-topic","topic.ly.liu","超级碗",correlationData);
    }
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("发送消息成功,id为:" + correlationData.getId());
        } else {
            System.out.println("发送失败,原因:" + cause);
        }
    }
}
