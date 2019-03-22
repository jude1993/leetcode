package future2;

/**
 * @author ：wupeng
 * @date ：Created in 10:06 2019/1/4
 * @description：
 */
public class Server {
  public static void main(String[] args) {
      Client client = new Client();
      RequestData data = client.request("doRequest");
    System.out.println("进行其它计算");
      try {
          Thread.sleep(1000L);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
    System.out.println("其它计算完成");
    System.out.println(data.getValue());
  }
}
