package rabbitmq.Routing;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ：wupeng
 * @date ：Created in 15:05 2019/4/8
 * @description：
 */
public class ReceiveLog implements Runnable{
    private static final String EXCHANGE_NAME = "direct_log";

    private String[] routingKeys;
    private String name;

    public ReceiveLog(String[] keys, String name){
        this.routingKeys = keys;
        this.name = name;
    }


    @Override
    public void run() {
        ConnectionFactory factory = new ConnectionFactory();
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME,"direct");
            String queueName = channel.queueDeclare().getQueue();
            for(String key : routingKeys){
                channel.queueBind(queueName,EXCHANGE_NAME,key);
                System.out.println(name + " exchange:"+EXCHANGE_NAME+"," +
                        " queue:"+queueName+", BindRoutingKey:" + key);
            }
            System.out.println(name + " Waiting for messages");
            DefaultConsumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(name + " Received '" + envelope.getRoutingKey() + "':'" + message + "'");
                }
            };
            channel.basicConsume(queueName, true, consumer);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
