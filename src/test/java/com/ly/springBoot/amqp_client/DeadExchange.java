package com.ly.springBoot.amqp_client;

import com.ly.springBoot.action.mq.amqp_client.MqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: LiuYi
 * @Description: 设置队列的其他属性,如:Dead letter exchange(死亡交换机) 和 Dead letter routing key(死亡路由键)
 * @Date: Created in 2018/7/13 15:17
 */
public class DeadExchange {
    public static void main(String[] args) {
        testDeadExchange();
    }

    public static void testDeadExchange() {
        Channel channel = null;
        try {
            channel = MqUtils.getChannel();
            //声明死亡交换机跟死亡路由键,并为该交换机绑定一个队列
            String EXCHANGE_DEAD_NAME = "exchange-dead";
            String QUEUE_DEAD = "queue-dead";
            String ROUTING_KEY_DEAD = "routing-key-dead";
            channel.exchangeDeclare(EXCHANGE_DEAD_NAME, "direct");
            channel.queueDeclare(QUEUE_DEAD, false, false, false, null);
            channel.queueBind(QUEUE_DEAD, EXCHANGE_DEAD_NAME, ROUTING_KEY_DEAD);

            String EXCHANGE_NAME = "exchange-fanout";//该交换器已经存在

            //设置特定队列
            String QUEUE_NAME = "queue-fanout-especial";
            HashMap<String, Object> map = new HashMap<>();
            map.put("x-message-ttl", 15000);//设置队列中的所有消息的生存周期
            map.put("x-max-length", 5);//限定队列的消息的最大值长度
            map.put("x-dead-letter-exchange", EXCHANGE_DEAD_NAME);//指定死亡交换机
            map.put("x-dead-letter-routing-key", ROUTING_KEY_DEAD);//指定死亡路由键
            channel.queueDeclare(QUEUE_NAME, false, false, false, map);

            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

            channel.confirmSelect();
          for (int i = 1; i <= 6; i++) {
                String msg = "死亡消息" + i;
                channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());
            }
            boolean isAllPublished  = channel.waitForConfirms();
            System.out.println("isAllPublished:"+isAllPublished);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            MqUtils.close(channel);
        }
    }
}
