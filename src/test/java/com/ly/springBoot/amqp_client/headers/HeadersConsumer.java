package com.ly.springBoot.amqp_client.headers;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/7/13 11:01
 */
public class HeadersConsumer {
    public static void main(String[] args) {
        receiveMsg();
    }

    public static void receiveMsg() {
        Channel channel = null;
        try {
//            channel = MqUtils.getChannel();
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");
            factory.setPort(AMQP.PROTOCOL.PORT);
            factory.setVirtualHost("my-vhosts"); // 指定虚拟主机的名称，默认是"/"
            Connection connection = factory.newConnection();
            channel = connection.createChannel();
            String EXCHANGE_NAME = "exchange-headers";
            //声明交换机
            channel.exchangeDeclare(EXCHANGE_NAME, "headers");
            //声明队列
            String QUEUE_NAME = "queue-ttl";
            HashMap<String, Object> queueArguments = new HashMap<>();
            queueArguments.put("x-message-ttl", 10000);//统一为队列声明消息存活时间,单位为毫秒
            channel.queueDeclare(QUEUE_NAME,false,false,false,queueArguments);
            //绑定队列交换机
            HashMap<String, Object> arguments = new HashMap<>();
            arguments.put("x-match", "all");
            arguments.put("version", 1.0);
            arguments.put("userName", "userName");
            arguments.put("pwd", "pwd");
            // 队列绑定时需要指定参数,注意虽然不需要路由键但仍旧不能写成null，需要写成空字符串""
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "", arguments);
            System.out.println("Consumer Wating Receive Message");
            //接受消息
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("接收到消息:" + new String(body, "UTF-8"));
                }
            };
            channel.basicConsume(QUEUE_NAME, true, consumer);
            Thread.sleep(100000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            MqUtils.close(channel);
        }
    }
}
