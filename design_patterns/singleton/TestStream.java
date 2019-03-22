package singleton;

/**
 * @author ：wupeng
 * @date ：Created in 9:50 2018/10/19
 * @description：
 */
public class TestStream {
  private String name;

  /**
   * 私有实例
   * */
  private static TestStream instance;

  /**
   * 私有化构造方法
   * */
  private TestStream() {}

  /**
   * 暴露获取实例接口
   * */
  public static TestStream getInstance(){
      if(instance == null){
          instance = new TestStream();
      }
      return instance;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
