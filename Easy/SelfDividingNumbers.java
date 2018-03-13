import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: jude
 * @Date: Create in 18:32 2018/3/8
 * @Description:Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *      For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *      Input:
 *      left = 1, right = 22
 *      Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = left; i<=right; i++){
            if(fun(i)) list.add(i);
        }
        return list;
    }

    private boolean fun(int i){
        int a = i;
        while(a>0){
            if(a%10==0){
                return false;
            }
            if(!(i%(a%10)==0)){
                return false;
            }
            a = a/10;
        }
        return true;
    }
    @Test
    public void testSulotion(){
        selfDividingNumbers(1,22);
    }

}
