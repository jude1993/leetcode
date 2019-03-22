package future;

/**
 * @author ：wupeng
 * @date ：Created in 16:01 2019/1/3
 * @description：
 */
public class RealData implements RequestData{
    protected  String  result;

    public RealData(String para){
        //构造比较慢
        StringBuffer sb= new StringBuffer();
        for(int i=0;i<10;i++){
            sb.append(para);
            try{
                Thread.sleep(1000);
            }catch(Exception e){

            }
            result= sb.toString();
        }
    System.out.println("实际结果计算完成");
    }



    @Override
    public String getResult() {

        return result;
    }
}
