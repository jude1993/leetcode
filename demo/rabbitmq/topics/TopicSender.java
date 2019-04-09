package rabbitmq.topics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ：wupeng
 * @date ：Created in 15:42 2019/4/8
 * @description：
 */
public class TopicSender {
    private static final String EXCHANGE_NAME = "topic_log";

    public void doProcess() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"topic");
        //待发送的消息
        String[] routingKeys=new String[]{
                "quick.orange.rabbit",
                "lazy.orange.elephant",
                "quick.orange.fox",
                "lazy.brown.fox",
                "quick.brown.fox",
                "quick.orange.male.rabbit",
                "lazy.orange.male.rabbit"
        };
        for(String key : routingKeys){
            for(int i=0; i<2; i++){
                String message = "key = " + key + " msg " + i ;
                channel.basicPublish(EXCHANGE_NAME,key,null,message.getBytes());
        System.out.println("send " + message);
            }
        }
    }
}
