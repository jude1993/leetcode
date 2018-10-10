package singleton;

/**
 * @author ：wupeng
 * @date ：Created in 15:16 2018/10/8
 * @description：
 */
public class Singleton {

  public static Singleton instance;

  private Singleton() {}

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}
