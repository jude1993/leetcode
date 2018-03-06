import org.junit.jupiter.api.Test;

/**
 * @Author: jude
 * @Date: Create in 12:31 2018/3/6
 * @Description: Given a 32-bit signed integer, reverse digits of an integer.
 *          Note:
                    Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
                    For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public int solution(int x){
        int result = 0;
        if(x>-10 && x<10){
            return x;
        }
        while(true){
            result = result*10 + x%10;
            if((x/=10) == 0){
                return result;
            }
            if(result > 214748364 || result < -214748364){
                return 0;
            }
        }
    }
    @Test
    public void solutionTest(){
        solution(-123);
    }
}
