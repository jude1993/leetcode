package future;

/**
 * @author ：wupeng
 * @date ：Created in 15:40 2019/1/3
 * @description：
 */
public class Server {
  public static void main(String[] args) {
      Client client = new Client();
      RequestData future = client.request("future");
      try {
      System.out.println("进行其它计算。。。");
          Thread.sleep(1000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
    System.out.println("计算完成，打印结果");
    System.out.println(future.getResult());
  }
}
