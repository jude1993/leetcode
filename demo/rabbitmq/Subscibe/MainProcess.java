package rabbitmq.Subscibe;

/**
 * @author ：wupeng
 * @date ：Created in 10:48 2019/4/8
 * @description：
 */
public class MainProcess {
  public static void main(String[] args) throws InterruptedException {
      EmitLog emitLog = new EmitLog();

      Thread thread1 = new Thread(new ReceiveLog("T1"));

      Thread thread2 = new Thread(new ReceiveLog("T2"));
      thread1.start();
      thread2.start();
      Thread.sleep(1000L);
      emitLog.doProducting();
  }
}
