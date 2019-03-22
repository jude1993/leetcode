package future;

/**
 * @author ：wupeng
 * @date ：Created in 15:55 2019/1/3
 * @description：
 */
public class FutureData implements RequestData{

    protected RealData realData =null;
    protected boolean isReady = false;
    public synchronized void setRealData(RealData realData){
        if(isReady){
            return;
        }
        this.realData=realData;
        isReady=true;
        notifyAll();

    }

    @Override
    public  synchronized  String getResult() {
        while(!isReady){
            try{
        System.out.println("wait....");
                wait();
            }catch (Exception e){

            }
        }
        return realData.result;
    }
}
