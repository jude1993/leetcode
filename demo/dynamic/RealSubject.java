package dynamic;

/**
 * @author ：wupeng
 * @date ：Created in 14:45 2019/1/10
 * @description：
 */
public class RealSubject implements Subject{

    @Override
    public void doSome() {
    System.out.println("this is " + this.getClass().getName());
    }
}
