package rabbitmq.Dispense;

import rabbitmq.basic.MyConsumer;

/**
 * @author ：wupeng
 * @date ：Created in 17:51 2019/4/4
 * @description：
 */
public class MainProcess {
  public static void main(String[] args) {

      MyConsumer consumer1 = new MyConsumer("consumer1");
      Thread thread1 = new Thread(consumer1);
      thread1.start();

      MyConsumer consumer2 = new MyConsumer("consumer2");
      Thread thread2 = new Thread(consumer2);
      thread2.start();
      NewTask task = new NewTask();
      task.send();
  }
}
