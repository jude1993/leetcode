package rabbitmq;

import java.io.IOException;

/**
 * @author ：wupeng
 * @date ：Created in 9:45 2019/4/3
 * @description：
 */
public class Provider extends BaseConnection {

    public void sendMessage(String msg){
        try {
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            System.out.println("send :"+msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
