package rabbitmq.Subscibe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ：wupeng
 * @date ：Created in 10:25 2019/4/8
 * @description：
 */
public class EmitLog {
    private static final String EXCHANGE_NAME = "logs";

    public void doProducting() {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
            //分发消息
            for(int i=0; i<20; i++){
                String message = "msg: "+i;
                channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println(message + " has send");
            }
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
