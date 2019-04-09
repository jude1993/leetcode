package rabbitmq.basic;

/**
 * @author ：wupeng
 * @date ：Created in 9:45 2019/4/3
 * @description：
 */
public class MainProcess {
  public static void main(String[] args) {
      MyConsumer consumer = new MyConsumer();

      Thread thread = new Thread(consumer);
      thread.start();
      Provider provider = new Provider();
      for(int i=0; i<100; i++){
          provider.sendMessage(String.valueOf(i));
      }
  }
}
