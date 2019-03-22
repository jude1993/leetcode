package future2;

/**
 * @author ：wupeng
 * @date ：Created in 10:13 2019/1/4
 * @description：
 */
public class RealData implements RequestData {
    protected  String  result;

    public RealData(){
        String str = "real";
        for(int i=0; i<20; i++){
            try {
                Thread.sleep(100L);
                str += i;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("真实值构建完成");
        this.result = str;
    }

    @Override
    public String getValue() {
       return result;
    }
}
