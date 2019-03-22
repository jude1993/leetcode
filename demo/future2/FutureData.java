package future2;

/**
 * @author ：wupeng
 * @date ：Created in 10:09 2019/1/4
 * @description：
 */
public class FutureData implements RequestData {

    private boolean isReal = false;

    private RealData realData;

    @Override
    public synchronized String getValue() {
        while(!isReal){
            try {
        System.out.println("等待真实值构建");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getValue();
    }

    public boolean isReal() {
        return isReal;
    }

    public void setReal(boolean real) {
        isReal = real;
    }

    public RealData getRealData() {
        return realData;
    }

    public synchronized void setRealData(RealData realData) {
        if(isReal){
            return;
        }
        this.realData = realData;
        this.isReal = true;
        notifyAll();
    }
}
