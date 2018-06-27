package com.ly.springBoot.action;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/6/27 17:48
 */
public class RabbitMqTestAction {
    public void test() throws IOException {
        // 创建连接工厂
        ConnectionFactory cf = new ConnectionFactory();
        // 设置rabbitmq服务器IP地址
        cf.setHost("*.*.*.*");
        // 指定端口，默认5672
        cf.setPort(AMQP.PROTOCOL.PORT);
        // 设置rabbitmq服务器用户名
        cf.setUsername("***");
        // 设置rabbitmq服务器密码
        cf.setPassword("***");
        // 获取一个新的连接
        Connection connection = cf.newConnection();
        // 创建一个通道
        Channel channel = connection.createChannel();


        /**
         * 申明一个队列，如果这个队列不存在，将会被创建
         * @param queue 队列名称
         * @param durable 持久性：true队列会再重启过后存在，但是其中的消息不会存在。
         * @param exclusive 是否只能由创建者使用，其他连接不能使用。
         * @param autoDelete 是否自动删除（没有连接自动删除）
         * @param arguments 队列的其他属性(构造参数)
         * @return Queue.DeclareOk：宣告队列的声明确认方法已成功声明。
         * @throws java.io.IOException if an error is encountered
         */
        channel.queueDeclare("testQueue", true, false, false, null);

        /**
         * 声明一个 exchange.
         * @param exchange 名称
         * @param type  exchange type：direct、fanout、topic、headers
         * @param durable 持久化
         * @param autoDelete 是否自动删除（没有连接自动删除）
         * @param arguments 队列的其他属性(构造参数)
         * @return 成功地声明了一个声明确认方法来指示交换。
         * @throws java.io.IOException if an error is encountered
         */
        channel.exchangeDeclare("leitao", "topic", true, false, null);

        /**
         * 将队列绑定到Exchange，不需要额外的参数。
         * @param queue 队列名称
         * @param exchange 交换机名称
         * @param routingKey 路由关键字
         * @return Queue.BindOk：如果成功创建绑定，则返回绑定确认方法。
         * @throws java.io.IOException if an error is encountered
         */
        channel.queueBind("testQueue", "leitao", "testRoutingKey");

        /**
         * 发布一条不用持久化的消息，且设置两个监听。
         * @param exchange 消息交换机名称,空字符串将使用直接交换器模式，发送到默认的Exchange=amq.direct。此状态下，RoutingKey默认和Queue名称相同
         * @param routingKey 路由关键字
         * @param mandatory 监听是否有符合的队列
         * @param immediate 监听符合的队列上是有至少一个Consumer
         * @param BasicProperties  设置消息持久化：MessageProperties.PERSISTENT_TEXT_PLAIN是持久化；MessageProperties.TEXT_PLAIN是非持久化。
         * @param body 消息对象转换的byte[]
         * @throws java.io.IOException if an error is encountered
         */
        channel.basicPublish("", queueName, true, false, MessageProperties.TEXT_PLAIN, SerializationUtils.serialize(object));


        //关闭管道和连接
        channel.close();
        connection.close();

    }


}
