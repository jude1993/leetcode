package Thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：wupeng
 * @date ：Created in 14:16 2018/12/27
 * @description：
 */
public class ThreadUtils {

  private int threadNums;

  private ThreadPoolExecutor executor;

  private Runnable runnable;

  public void build(
      int corePoolSize,
      int maxNumPoolSize,
      long keepAliveTime,
      TimeUnit unit,
      int capacity,
      String nameFormat) {

    ThreadFactory build = new ThreadFactoryBuilder().setNameFormat(nameFormat).build();
    this.executor =
        new ThreadPoolExecutor(
            corePoolSize,
            maxNumPoolSize,
            keepAliveTime,
            unit,
            new LinkedBlockingDeque<Runnable>(capacity),
            build,
            new ThreadPoolExecutor.AbortPolicy());
  }

  public void count() {
    this.threadNums--;
  }

  public int getThreadNums() {
    return threadNums;
  }

  public void setThreadNums(int threadNums) {
    this.threadNums = threadNums;
  }

  public ThreadPoolExecutor getExecutor() {
    return executor;
  }

  public void setExecutor(ThreadPoolExecutor executor) {
    this.executor = executor;
  }

  public Runnable getRunnable() {
    return runnable;
  }

  public void setRunnable(Runnable runnable) {
    this.runnable = runnable;
  }
}
