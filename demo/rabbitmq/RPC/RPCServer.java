package rabbitmq.RPC;

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
 * @date ：Created in 17:02 2019/4/8
 * @description：
 */
public class RPCServer implements Runnable{
    private static final String RPC_QUEUE_NAME = "rpc_queue";

    private String name;

    private static int fib(int i){
        if(i == 1){
            return 1;
        }
        if(i == 0){
            return 0;
        }
        return fib(i-1) + fib(i-1);
    }

    public RPCServer(String name){
        this.name = name;
    }


    @Override
    public void run() {
        ConnectionFactory factory = new ConnectionFactory();
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(RPC_QUEUE_NAME,false,false,false,null);
            channel.basicQos(1);
            channel.queueDeclare().getQueue();


            DefaultConsumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(
                        String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String msg = new String(body, "UTF-8");
                    System.out.println(name + " received message = " + msg);
                }
            };

            channel.basicConsume(RPC_QUEUE_NAME,false,consumer);
      System.out.println("RPCServer awaiting for RPC request");
            while(true){
            }
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }

    }
}
