package Thread;

import java.util.concurrent.TimeUnit;

/**
 * @author ：wupeng
 * @date ：Created in 11:10 2018/12/26
 * @description：
 */
public class ThreadPoolDemo {
  public static void main(String[] args) {
    ThreadUtils utils = new ThreadUtils();
    utils.build(3, 5, 10, TimeUnit.MILLISECONDS, 5, "pool_excute_%d");
    CountLauncher countLauncher = new CountLauncher(10);
    for (int i = 0; i < 1000; i += 100) {
      utils.getExecutor().execute(new MyTask(i, i + 100, countLauncher));
    }
    while (!countLauncher.allFinshed()) {
      if (countLauncher.allFinshed()) {
        break;
      }
    }
    System.out.println("finished " + countLauncher.getCount());
  }

  static class MyTask implements Runnable {

    private int start;
    private int end;
    private CountLauncher countLauncher;

    MyTask(int start, int end, CountLauncher countLauncher) {
      this.start = start;
      this.end = end;
      this.countLauncher = countLauncher;
    }

    @Override
    public void run() {
      for (int index = start; index < end; index++) {
        System.out.println(Thread.currentThread().getName() + "_" + index);
      }
      countLauncher.countDown();
      System.out.println("now==" + countLauncher.getCount());
    }
  }
}
