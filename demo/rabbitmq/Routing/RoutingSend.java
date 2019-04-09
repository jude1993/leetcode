package rabbitmq.Routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ：wupeng
 * @date ：Created in 10:58 2019/4/8
 * @description：
 */
public class RoutingSend {
    private static final String EXCHANGE_NAME = "direct_log";

    private static final String[] routingKeys = new String[]{"info", "warning", "error"};

    public void doProducting() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        for(String key : routingKeys){
            String message = "send msg " + key;
            channel.basicPublish(EXCHANGE_NAME, key,null, message.getBytes());
      System.out.println("send message: "+message);
        }
    }

}
