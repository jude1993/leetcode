import org.junit.jupiter.api.Test;

/**
 * @Author: jude
 * @Date: Create in 10:13 2018/3/20
 * @Description:
 */
public class FooBar {
    private ICallBack callBack;

    public void setCallBack(ICallBack callBack){
        this.callBack = callBack;
    }

    public void doSth(){
        callBack.postExec();
    }


    @Test
    public void testPostExec(){
        FooBar fooBar = new FooBar();
        fooBar.setCallBack(() -> System.out.println("在test类中实现，但不能被test的对象调用，而又FooBar对象调用"));
        fooBar.callBack.postExec();
    }
}
