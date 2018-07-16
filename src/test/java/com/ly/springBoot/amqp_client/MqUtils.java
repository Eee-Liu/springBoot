package com.ly.springBoot.amqp_client;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/7/11 17:42
 */
public class MqUtils {
    private static ConnectionFactory connectionFactory;
    private static Connection connection;

    public static Channel getChannel() throws IOException {
        if (null == connectionFactory) {
            getFactory();
        }
        connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        return channel;
    }

    private static void getFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(AMQP.PROTOCOL.PORT);
        connectionFactory = factory;
    }

    public static void close(Channel channel) {
        try {
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
