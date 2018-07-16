package com.ly.springBoot.amqp_client.rpcMode;

import com.ly.springBoot.action.mq.amqp_client.MqUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.UUID;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/7/12 16:45
 */
public class Client {
    public static void main(String[] args) {
        client();
    }

    public static void client() {
        try {
            Channel channel = MqUtils.getChannel();
            String rpc_queue = "queue-rpc";
            String correlationId = UUID.randomUUID().toString();
            String replyToQueue = channel.queueDeclare().getQueue();
            //发送请求消息
            String message = "Hello RabbitMQ";
            AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                    .correlationId(correlationId).replyTo(replyToQueue).build();
            //发送到默认的交换机,所有queue都会自动绑定到默认的交换器上bingKey等于队列名
            channel.basicPublish("", rpc_queue, properties, message.getBytes());
            System.out.println("已发出请求请求消息：" + message);

            //订阅server返回消息
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    if (correlationId.equals(properties.getCorrelationId())) {
                        String msg = new String(body, "UTF-8");
                        System.out.println("已接收到服务器的响应结果：" + msg);
                    }
                }
            };
            channel.basicConsume(replyToQueue, true, consumer);
            Thread.sleep(100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
