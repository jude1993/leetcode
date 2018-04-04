import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: jude
 * @Date: Create in 14:52 2018/3/14
 * @Description: Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 * Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister.
 * Return the maximum number of kinds of candies the sister could gain.
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<Integer>();
        for (int candy : candies) {
            set.add(candy);
        }
        return set.size() >= candies.length /2 ? candies.length/2 : set.size();
    }

    public int distributeCandies2(int[] candies) {
        boolean[] seen = new boolean[200001];
        int ct = 0;
        int half = candies.length/2;
        for (int i = 0, inx = 0; i < candies.length && ct < half; i++) {
            inx = candies[i] + 100000;
            if (!seen[inx]) {
                ct++;
                seen[inx] = true;
            }
        }
        return ct <= half ? ct : half;
    }

    @Test
    public void testDistributeCandies(){
        System.out.println(distributeCandies(new int[]{1,1,2,2,3,3}));
    }
}
