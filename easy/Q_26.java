/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * nums = [1,1,1,2], 2 [1,2]
 * 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * [0,0,1,1,1,2,2,3,3,4]
 */
public class Q_26 {

    public static void main(String[] args) {
        Q_26 q = new Q_26();
        int i = q.removeDuplicates(new int[]{1, 2});
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int num = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    if (j != i + 1) {
                        int temp = nums[i + 1];
                        nums[i + 1] = nums[j];
                        nums[j] = temp;
                    }
                    num = num + 1;
                    break;
                } else if (j == nums.length - 1) {
                    return num;
                }
            }
        }
        return num;
    }


    /**
     * 最佳答案
     * */
    public int removeDuplicates_2(int[] nums) {
        int index = 0;
        if (nums.length == 0) {
            return 0;
        }
        for (int j = 1; j < nums.length; j++) {
            if (nums[index] != nums[j]) {
                index++;
                nums[index] = nums[j];
            }
        }
        return index + 1;
    }
}
