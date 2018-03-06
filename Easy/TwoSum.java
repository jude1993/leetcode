import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jude
 * @Date: Create in 11:13 2018/3/6
 * @Description: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    /**
     * n*2
     * 30ms
     */
    public int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 7ms
     * */
    public int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(record.containsKey(target-nums[i])){
                return new int[]{i,record.get(target-nums[i])};
            }
            record.put(nums[i],i);
        }
        return null;
    }

    void printArr(int[] arr) {
        String str = "";
        for (int a : arr) {
            str += a + " ";
        }
        System.out.println(str);
    }

    @Test
    public void testTwoSum() {
        printArr(solution1(new int[]{2, 7, 11, 15}, 18));
    }


}
