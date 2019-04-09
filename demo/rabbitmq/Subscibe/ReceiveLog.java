package rabbitmq.Subscibe;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @author ：wupeng
 * @date ：Created in 10:31 2019/4/8
 * @description：
 */
public class ReceiveLog implements Runnable{
    private static final String EXCHANGE_NAME = "logs";

    private String name;
    public ReceiveLog(String name){
        this.name = name;
    }
    @Override
    public void run() {
        ConnectionFactory factory = new ConnectionFactory();
        try{
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
            String queue = channel.queueDeclare().getQueue();
            //绑定队列
            channel.queueBind(queue,EXCHANGE_NAME,"");
            System.out.println("ReceiveLog1 waiting for message");
            DefaultConsumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(name +" Received '" + message + "'");
                }
            };
            channel.basicConsume(queue,true,consumer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
