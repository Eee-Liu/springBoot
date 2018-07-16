package com.ly.springBoot.amqp_client.direct;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/7/10 16:52
 */
public class DirectConsumer2 {
    public static void main(String[] args) {
        receiveMsg("queue.work");
    }
    public static void receiveMsg(String queueName) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(AMQP.PROTOCOL.PORT);
        Channel channel = null;
        Connection connection = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            // 设置每次从队列获取消息的数量
            channel.basicQos(1);

            //声明队列
            String QUEUE_NAME = queueName;
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            System.out.println("Consumer Wating Receive Message");

            Channel finalChannel = channel;
            Consumer consumer = new DefaultConsumer(finalChannel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                           byte[] body) throws IOException{
                    String msg = new String(body, "UTF-8");
                    System.out.println(" [C2] Received '" + msg + "', 处理业务中...");
                    try {
                        Thread.sleep(500);
                        finalChannel.basicAck(envelope.getDeliveryTag(), false); //手动消息确认，反馈确认信息
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            //订阅消息, false: 表示手动应答,需要手动调用basicAck()来应答,
            // 公平分发模式需要手动消息确认
            channel.basicConsume(QUEUE_NAME,false,consumer);
            // 睡眠是为了不让程序立即结束，这样还有机会获取第二条消息
            Thread.sleep(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
