/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 1,8,6,2,5,4,8,3,7
 */
public class Q_11 {

    public static void main(String[] args) {
        Q_11 q = new Q_11();
        int i = q.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;

        int max = 0;
        while (i != j) {
            int v = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(max, v);
            if (height[i] > height[j]) {
                j = j - 1;
            } else {
                i = i + 1;
            }
        }
        return max;
    }

    public int maxArea_2(int[] height) {

        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int min = Math.min(height[i], height[j]);
                int v = Math.abs((j - i)) * min;
                max = Math.max(max, v);
            }
        }
        return max;
    }
}
