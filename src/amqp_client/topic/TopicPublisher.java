package com.ly.springBoot.amqp_client.topic;


import com.ly.springBoot.amqp_client.MqUtils;
import com.rabbitmq.client.Channel;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/7/12 11:37
 */
public class TopicPublisher {
    public static void main(String[] args) {
        sendMsg();
    }

    public static void sendMsg() {
        Channel channel = null;
        try {
            channel = MqUtils.getChannel();
            String EXCHANGE_NAME = "exchange-topic";
            //声明交换机
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            String[] routingKeys = {"mq.orange.rabbit", "queue.orange.haha", "mq.liuyi.rabbit", "w.liuyi.com"};
            for (String routingKey : routingKeys) {
                String message = "Hello RabbitMQ - " + routingKey;
                channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MqUtils.close(channel);
        }
    }
}
