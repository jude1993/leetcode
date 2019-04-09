package rabbitmq.topics;

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
 * @date ：Created in 15:52 2019/4/8
 * @description：
 */
public class TopicConsumer implements Runnable{
    private static final String EXCHANGE_NAME = "topic_log";

    private String[] routingKeys;

    private String name;

    public TopicConsumer(String[] routingKeys, String name){
        this.routingKeys = routingKeys;
        this.name = name;
    }


    @Override
    public void run() {
        ConnectionFactory factory = new ConnectionFactory();
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME,"topic");
            String queueName = channel.queueDeclare().getQueue();

            for(String key : routingKeys){
                channel.queueBind(queueName,EXCHANGE_NAME,key);
        System.out.println(name + " exchange="+EXCHANGE_NAME +" queueName=" + queueName+" routingKey="+key);
            }
        System.out.println("waiting for message");

      DefaultConsumer consumer =
          new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(
                String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                throws IOException {
              String msg = new String(body, "UTF-8");
              System.out.println(
                  name + "received message " + msg + " routingKey=" + envelope.getRoutingKey());
            }
          };
            channel.basicConsume(queueName,true,consumer);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }

    }
}
