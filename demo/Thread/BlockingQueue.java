package Thread;

import java.util.concurrent.*;

/**
 * @author ：wupeng
 * @date ：Created in 10:30 2019/3/29
 * @description：
 */
public class BlockingQueue {
  public static void main(String[] args) {

      /**
       * 线程池的排队策略与BlockingQueue有关。
       * */

      ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

      new PriorityBlockingQueue();

      LinkedBlockingQueue<Object> queue2 = new LinkedBlockingQueue<>();

      SynchronousQueue queue3 = new SynchronousQueue();

      /**
       * 拒绝策略
       * */
      /**
       * 丢弃任务并抛出RejectedExecutionException异常
       * */
      new ThreadPoolExecutor.AbortPolicy();

      /**
       * 丢弃任务但是不抛出异常
       * */
      new ThreadPoolExecutor.DiscardPolicy();

      /**
       * 丢弃队列最前面的任务,然后重新尝试执行任务
       * */
      new ThreadPoolExecutor.DiscardOldestPolicy();

      /**
       * 由调用线程处理该任务
       * */
      new ThreadPoolExecutor.CallerRunsPolicy();

  }
}
