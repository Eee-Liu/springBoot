package com.ly.springBoot.action.mq.direct;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/7/13 18:05
 */
@Controller
@RequestMapping("/sendMsg")
public class DirectSender implements RabbitTemplate.ConfirmCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/direct.do")
    public void sendMessage() {
        Map<String, Object> log = new HashMap<String, Object>();
        log.put("level", "info");
        log.put("timestamp", new Date());
        log.put("operateId", 666);
        log.put("msg", "修改密码，修改前密码：123456，修改后密码：111111");
        //设置回调为当前类对象
        rabbitTemplate.setConfirmCallback(this);
        //构建回调id为uuid
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        String EXCHANGE_NAME = "spring-exchange-direct";
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "spring-direct", log, correlationData);
        System.out.println("发送消息");
    }

    /**
     * 消息回调确认方法,当一个消息被成功写入到RabbitMQ服务端时，
     * 就会自动的回调RabbitTemplate.ConfirmCallback接口内的confirm方法完成通知
     *
     * @param correlationData 请求数据对象
     * @param ack             是否发送成功
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(" 回调id:" + correlationData.getId());
        if (ack) {
            System.out.println("消息发送成功");
        } else {
            System.out.println("消息发送失败:" + cause);
        }
    }
}
