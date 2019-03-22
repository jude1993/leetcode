package singleton;

/**
 * @author ：wupeng
 * @date ：Created in 9:57 2018/10/19
 * @description：
 */
public class SingletonE {

  private static SingletonE instance = new SingletonE();

  private SingletonE() {}

  public static SingletonE getInstance() {
    return instance;
  }
}
