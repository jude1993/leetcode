package Thread;

/**
 * @author ：wupeng
 * @date ：Created in 15:13 2018/12/27
 * @description：
 */
public class CountLauncher {
  private volatile int count;

  public CountLauncher(int count) {
    this.count = count;
  }

  public synchronized void countDown() {
    this.count--;
  }

  public boolean allFinshed() {
    return this.count == 0;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
