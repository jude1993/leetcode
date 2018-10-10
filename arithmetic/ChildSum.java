/**
 * @author ：wupeng
 * @date ：Created in 15:06 2018/8/24
 * @description：
 */
public class ChildSum {
  public static void main(String[] args) {
    int[] dp = dp(new int[] {-2, 11, -4, -13, 5, -2});
    int max = dp[0];
    for (int i = 1; i < dp.length; i++) {
      max = max > dp[i] ? max : dp[i];
    }
    System.out.println(max);
  }

  private static int[] dp(int[] n) {
    int[] result = new int[n.length];
    for (int i = 0; i < n.length; i++) {
      for (int j = i + 1; j < n.length; j++) {
        if (j == 0) {
          result[j] = n[j];
        } else if (result[j - 1] > 0) {
          result[j] = result[j - 1] + n[j];
        } else if (result[j - 1] <= 0) {
          result[j] = n[j];
        }
      }
    }
    return result;
  }
}
