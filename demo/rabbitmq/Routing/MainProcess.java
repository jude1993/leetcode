package rabbitmq.Routing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ：wupeng
 * @date ：Created in 15:17 2019/4/8
 * @description：
 */
public class MainProcess {
  public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
      Thread t1 = new Thread(new ReceiveLog(new String[]{"info", "warning"}, "t1"));
      Thread t2 = new Thread(new ReceiveLog(new String[]{"error"}, "t2"));
      RoutingSend sender = new RoutingSend();
      t1.start();
      t2.start();
      Thread.sleep(1000L);
      sender.doProducting();
  }
}
