package rabbitmq.topics;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ：wupeng
 * @date ：Created in 16:10 2019/4/8
 * @description：
 */
public class MainProcess {
  public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
      Thread t1 = new Thread(new TopicConsumer(new String[]{"*.orange.*.*"}, "t1"));
      Thread t2 = new Thread(new TopicConsumer(new String[]{"*.brown.*.*"}, "t2"));
      t1.start();
      t2.start();
      TopicSender sender = new TopicSender();
      Thread.sleep(1000L);
      sender.doProcess();
  }
}
