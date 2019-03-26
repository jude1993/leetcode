package Thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author ：wupeng
 * @date ：Created in 16:07 2019/3/22
 * @description：
 */
public class Demo1 {
  public static void main(String[] args) {
    /**
     *  可缓存线程池
     *  corePoolSize为零
     *  maximumPoolSize为Integer.MAX_VALUE
     *  keepAliveTime为60L
     *  TimeUnit 为 seconds
     *  workQueue 为SynchronousQueue 同步队列
     *  特点:
     *    当有新任务来到，则插入到SynchronousQueue中，SynchronousQueue
     *    是同步队列，因此会在池中寻找可以使用的线程来执行，若有线程可用就执行
     *    无线程可用就创建一个新的线程来执行；若线程池中线程超过空闲时间，则会销毁该线程
     *  使用场景：执行很多短期异步的小程序或者负载较轻的服务器
     *  */
    ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 可变长的线程池
     * Param nThread所指定的线程数量
     * corePoolSize为nThread
     * maximumPoolSize为nThread
     * keepAliveTime为0L(不限时)
     * unit为TimeUnit.MILLISECONDS
     * workQueue为 new LinkedBlockingQueue<Runnable>()无界阻塞队列
     * 特点:
     *    创建可容纳固定数量线程的池子，每个线程的存活时间是无限的
     *    当池子满了就不再添加线程，如果池中的所有线程均在繁忙状态，对于新任务会进入阻塞队列中(无界阻塞队列)
     *  场景：执行长期的任务，性能好很多
     * */
      ExecutorService executorService1 = Executors.newFixedThreadPool(10);

      /**
       * 单个线程的线程池
       * FinalizableDelegatedExecutorService包装的ThreadPoolExecutor实例
       * corePoolSize为1
       * maximumPoolSize为1
       * keepAliveTime为0
       * unit为TimeUnit.MILLISECONDS
       * workQueue为new LinkedBlockingQueue<Runnable>无界阻塞队列
       * 场景：一个任务一个任务执行的场景
       * */
      ExecutorService executorService2 = Executors.newSingleThreadExecutor();
      /**
       * 定时线程池
       * ScheduledThreadPoolExecutor实例，corePoolSize为传递来的参数
       * maximumPoolSize为Integer.MAX_VALUE
       * keepAliveTime为0
       * unit为TimeUnit.NANOSECONDS
       * workQueue为new DelayedWordQueue()一个按超时时间升序排序的队列
       * 特点：
       *   创建一个固定大小的线程池，线程池内线程数无限制，线程池可以支持定时及周期性任务执行
       *   ，如果所有线程均处于繁忙状态，对于新任务会进入DelayedWordQueue队列中，
       *   、这是一种按照超是时间排序的队列结构
       * 使用场景: 周期性执行任务的场景
       * */
      ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

  }
}
