package com.ly.springBoot.amqp_client.direct;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Description: 工作队列
 * @Date: Created in 2018/7/10 16:35
 */
public class DirectPublisher {
    public static void main(String[] args) {
        sendMsg();
    }
    public static void sendMsg() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(AMQP.PROTOCOL.PORT);

        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            String QUEUE_NAME = "queue.work";
            String ROUTING_KEY = "task";
            String EXCHANGE_NAME = "amqp.rabbitmq.work";
            //声明交换器:指定交换机的名称和类型(direct)
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            //声明队列
             /*第一个参数表示队列名称
            第二个参数为是否持久化（true表示是，队列将在服务器重启时生存）
            第三个参数为是否是独占队列（创建者可以使用的私有队列，断开后自动删除）
            第四个参数为当所有消费者客户端连接断开时是否自动删除队列
            第五个参数为队列的其他参数*/
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            //绑定交换器跟队列
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
            //发布消息
            for (int i = 0; i < 10; i++) {
                String msg = "rabbitMq msg " + i;
                //MessageProperties.PERSISTENT_TEXT_PLAIN 消息持久化
                channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
