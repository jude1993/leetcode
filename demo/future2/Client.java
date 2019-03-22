package future2;

/**
 * @author ：wupeng
 * @date ：Created in 10:05 2019/1/4
 * @description：
 */
public class Client {
    public RequestData request(String param){
        final FutureData futureData = new FutureData();
    new Thread(
            () -> {
                System.out.println("开始计算真实值");
                RealData realData = new RealData();
              futureData.setRealData(realData);
            })
        .start();
    System.out.println("返回虚拟值");
        return futureData;
    }
}
