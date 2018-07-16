package com.ly.springBoot.amqp_client.rpcMode;


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
 * @Date: Created in 2018/7/12 16:46
 */
public class Server {
    public static void main(String[] args) {
        server();
    }

    public static void server() {
        try {
            Channel channel = MqUtils.getChannel();
            //声明请求消息队列
            String rpc_queue = "queue-rpc";
            channel.queueDeclare(rpc_queue, false, false, false, null);
            //订阅请求信息
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("服务端：已接收到请求消息：" + message);
                    // 服务器端接收到消息并处理消息
                    String response = "{'code': 200, 'data': '" + message + "'}";
                    //发送响应信息
                    AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder()
                            .correlationId(properties.getCorrelationId()).build();
                    channel.basicPublish("", properties.getReplyTo(), basicProperties, response.getBytes());
                    //手动确认消息
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            };
            channel.basicConsume(rpc_queue, false, consumer);
            Thread.sleep(100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
