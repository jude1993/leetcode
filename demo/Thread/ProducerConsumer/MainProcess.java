package Thread.ProducerConsumer;

import java.util.concurrent.*;

/**
 * @author ：wupeng
 * @date ：Created in 17:20 2019/3/19
 * @description：
 */
public class MainProcess {
  public static void main(String[] args) throws Exception{
      BlockingQueue<PCData> queue = new LinkedBlockingDeque<>(10);
      Producer p1 = new Producer(queue);
      Producer p2 = new Producer(queue);
      Producer p3 = new Producer(queue);
      Consumer c1 = new Consumer(queue);
      Consumer c2 = new Consumer(queue);
      Consumer c3 = new Consumer(queue);
      ExecutorService service = Executors.newCachedThreadPool();
      service.execute(p1);
      service.execute(p2);
      service.execute(p3);
      service.execute(c1);
      service.execute(c2);
      service.execute(c3);
      Thread.sleep(10*1000);
      p1.stop();
      p2.stop();
      p3.stop();
      Thread.sleep(3000);
      service.shutdown();
    System.out.println("main end");
  }
}
