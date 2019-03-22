package future;

/**
 * @author ：wupeng
 * @date ：Created in 15:40 2019/1/3
 * @description：
 */
public class Client {
  public static void main(String[] args) {

  }

  public RequestData request(String value){
      FutureData futureData = new FutureData();
    new Thread(() -> {
        RealData realData = new RealData(value);
        futureData.setRealData(realData);
        System.out.println("设置真实返回值");
    }).start();
    System.out.println("返回future对象");
      return futureData;
  }
}
