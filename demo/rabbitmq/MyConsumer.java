package rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;

/**
 * @author ：wupeng
 * @date ：Created in 9:45 2019/4/3
 * @description：
 */
public class MyConsumer extends BaseConnection implements Runnable, Consumer{

    private String name;

    public MyConsumer(){}

    public MyConsumer(String name){
        this. name = name;
    }

    @Override
    public void run() {
        try {
            this.channel.basicConsume(QUEUE_NAME, true,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleConsumeOk(String s) {
        System.out.println("Consumer "+s +" registered");
    }

    @Override
    public void handleCancelOk(String s) {

    }

    @Override
    public void handleCancel(String s) throws IOException {

    }

    @Override
    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    @Override
    public void handleRecoverOk(String s) {

    }

    @Override
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        String msg = new String(bytes);
        System.out.println("Message Number "+ msg + " received. by "+name);
    }
}

