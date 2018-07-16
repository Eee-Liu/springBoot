package com.ly.springBoot.amqp_client.fanout;

import com.ly.springBoot.action.mq.amqp_client.MqUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/7/11 17:41
 */
public class FanoutConsumer1 {
    public static void main(String[] args) {
        receiveMsg();
    }
    public static void receiveMsg() {
        Channel channel = null;
        try { channel = MqUtils.getChannel();
            String QUEUE_NAME="queue-fanout-1";
            String EXCHANGE_NAME = "exchange-fanout";
            //声明队列
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            //声明交换机
//            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            //绑定交换器跟队列
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");

            System.out.println("Consumer Wating Receive Message");

            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String var1, Envelope var2, AMQP.BasicProperties var3, byte[] body) throws IOException{
                    String message = new String(body, "UTF-8");
                    System.out.println(" [C1] Received '" + message + "', 处理业务中(发短信)...");
                }
            };
            //接收消息
            channel.basicConsume(QUEUE_NAME,true,consumer);
            Thread.sleep(100000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            MqUtils.close(channel);
        }
    }
}
