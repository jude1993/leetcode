/**
 * https://leetcode-cn.com/problems/remove-element/
 */
public class Q_27 {

    public static void main(String[] args) {
        Q_27 q = new Q_27();
        int i = q.removeElement(new int[]{1, 2, 3, 4, 3}, 3);
        System.out.println(i);
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        int tem = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tem;
                        count = count + 1;
                        break;
                    }
                }
            }else{
                count = count + 1;
            }
        }
        return count;
    }
}
