import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jude
 * @Date: Create in 14:27 2018/3/14
 * @Description:Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    private List<String> fizzBuzz2(int n) {
        final int size = n;
        return new AbstractList<String>() {
            static final String FIZZ = "Fizz";
            static final String BUZZ = "Buzz";
            static final String FIZZ_BUZZ = "FizzBuzz";

            @Override
            public String get(int index) {
                index++;
                if(index %15==0){
                    return FIZZ_BUZZ;
                }else if(index % 3==0){
                    return FIZZ;
                }else if(index%5==0){
                    return BUZZ;
                }else{
                    return String.valueOf(index);
                }
            }

            @Override
            public int size() {
                return size;
            }
        };
    }

    @Test
    void testFizzBuzz() {
        System.out.println(fizzBuzz2(15));
    }
}
