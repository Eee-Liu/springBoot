package com.ly.springBoot.amqp_client.fanout;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Description: 扇形交换机
 * @Date: Created in 2018/7/11 17:33
 */
public class FanoutPublisher {
    public static void main(String[] args) {
        sendMsg();
    }
    public static void sendMsg() {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            String EXCHANGE_NAME = "exchange-fanout";
            //声明交换机
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            //推送消息
            for (int i = 0; i < 10; i++) {
                String msg = "rabbitMq msg " + i;
                AMQP.BasicProperties.Builder properties = new AMQP.BasicProperties()
                        .builder().expiration(  10000 + "");
                channel.basicPublish(EXCHANGE_NAME, "", properties.build(), msg.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != channel)
                    channel.close();
                if (null != connection)
                    connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
