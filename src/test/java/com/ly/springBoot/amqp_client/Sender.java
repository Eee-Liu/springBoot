package com.ly.springBoot.amqp_client;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Sender {
    private final static String QUEUE_NAME = "MyQueue";

    public static void main(String[] args) {
        send();
    }

    /**
     * (1)：创建ConnectionFactory，并且设置一些参数，比如hostname,portNumber等等
     * (2)：利用ConnectionFactory创建一个Connection连接
     * (3)：利用Connection创建一个Channel通道
     * (4)：创建queue并且和Channel进行绑定
     * (5)：创建消息，并且发送到队列中
     * 注意，在我们当前的例子中，并没有用到exchange交换机，RabbitMQ默认情况下是会创建一个空字符串名字的exchange的，如果我们没有创建自己的exchange的话，默认就是使用的这个exchange；
     */
    public static void send() {
        ConnectionFactory factory = null;
        Connection connection = null;
        Channel channel = null;
        try {
            factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");
//            factory.setPort(5672);
            connection = factory.newConnection();
            channel = connection.createChannel();
            /*第一个参数表示队列名称
            第二个参数为是否持久化（true表示是，队列将在服务器重启时生存）
            第三个参数为是否是独占队列（创建者可以使用的私有队列，断开后自动删除）
            第四个参数为当所有消费者客户端连接断开时是否自动删除队列
            第五个参数为队列的其他参数*/
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "my first message .....";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println("已经发送消息....." + message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                channel.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
