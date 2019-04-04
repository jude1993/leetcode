package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ：wupeng
 * @date ：Created in 10:51 2019/4/3
 * @description：
 */
public class BaseConnection {
    public static final String QUEUE_NAME = "spring_queue";
    public Connection connection = null;
    public Channel channel = null;

    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("jude");
        factory.setPassword("jude");
        try {
            this.connection = factory.newConnection();
            this.channel = connection.createChannel();
            this.channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

  public static void main(String[] args) {
      new BaseConnection();
  }
}
