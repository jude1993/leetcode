import java.util.LinkedHashMap;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 */
public class Q_503 {

    public static void main(String[] args) {
        Q_503 q = new Q_503();
        int[] ints = q.nextGreaterElements(new int[]{1,2,1});
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    //第二个答案
    //单调栈
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
        }
        Stack<Integer> temp = new Stack<>();

        for (int i = 0; i < 2 * nums.length; i++) {
            int index = i % nums.length;
            if (temp.isEmpty()) {
                temp.push(index);
                continue;
            }
            Integer peek = temp.peek();
            if (nums[peek] >= nums[index]) {
                temp.push(index);
                continue;
            }
            while (!temp.isEmpty() && nums[temp.peek()] < nums[index]) {
                Integer pop = temp.pop();
                result[pop] = nums[index];
            }
            temp.push(index);
        }
        return result;
    }

    //第一个答案
    public int[] nextGreaterElements1(int[] nums) {

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
            int count = i + 1;
            while (count != i) {
                if (count == nums.length) {
                    count = 0;
                    continue;
                }

                if (nums[count] > nums[i]) {
                    result[i] = nums[count];
                    count = i;
                    continue;
                }
                count = count + 1;
            }
        }
        return result;
    }
}
