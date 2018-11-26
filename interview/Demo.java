import org.junit.jupiter.api.Test;

/**
 * Created by jude on 2018/4/23.
 */
public class Demo {
public static void main(String[] args){
    System.out.println(foo(5));
    long temp = (int)3.9;
    temp%=2;
    System.out.println(temp);
    float x = 10/4;
    System.out.println(x);
}
    @Test
    public void test1(){
        System.out.println("0".equals(new Integer(0)));
        System.out.println(foo(5));
    }

    static int foo(int n){
        if(n<2) return n;
        return foo(n-1)+foo(n-2);
    }
}
