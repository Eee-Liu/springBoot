package com.ly.springBoot.amqp_client.topic;



import com.ly.springBoot.amqp_client.MqUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/7/12 11:38
 */
public class TopicConsumer2 {
    public static void main(String[] args) {
        receiveMsg();
    }

    public static void receiveMsg() {
        Channel channel = null;
        try {
            channel = MqUtils.getChannel();
            String EXCHANGE_NAME = "exchange-topic";
            String QUEUE_NAME = "queue-topic-2";

            //声明队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String[] routingKeys = {"#.com"};
            for (String routingKey : routingKeys) {
                channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, routingKey);
            }
            System.out.println("Consumer Wating Receive Message");

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [C2] Received '" + message + "', 处理业务中...");
                }
            };
            channel.basicConsume(QUEUE_NAME, true, consumer);
            Thread.sleep(100000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MqUtils.close(channel);
        }
    }
}
