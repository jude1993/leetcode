package rabbitmq.Dispense;

import com.rabbitmq.client.MessageProperties;
import rabbitmq.basic.BaseConnection;

import java.io.IOException;

/**
 * @author ：wupeng
 * @date ：Created in 17:44 2019/4/4
 * @description：
 */
public class NewTask extends BaseConnection {

  public void send() {
      for(int i=0; i<20; i++){
          String message = "this is message "+i;
          try {
              this.channel.basicPublish("",QUEUE_NAME,
                      MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
        System.out.println("send message " + i);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      try{
          channel.close();
          connection.close();
      }catch (Exception e){

      }

  }
}
