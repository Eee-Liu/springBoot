package com.ly.springBoot.amqp_client.headers;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.HashMap;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/7/13 11:02
 */
public class HeaderPubliser {
    public static void main(String[] args) {
        sendMsg();
    }

    public static void sendMsg() {
        Channel channel = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");
            factory.setPort(AMQP.PROTOCOL.PORT);
            factory.setVirtualHost("my-vhosts"); // 指定虚拟主机的名称，默认是"/"
            Connection connection = factory.newConnection();
            channel = connection.createChannel();
//            channel = MqUtils.getChannel();
            HashMap<String, Object> map = new HashMap<>();
            map.put("version", 1.0);
            map.put("userName", "userName");
            map.put("pwd", "pwd");

            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder().headers(map).build();
            String msg = "header rabbitMq msg";
            String EXCHANGE_NAME = "exchange-headers";
            channel.basicPublish(EXCHANGE_NAME, "", properties, msg.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            MqUtils.close(channel);
        }
    }
}
