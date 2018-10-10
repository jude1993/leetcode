/**
 * @author ：wupeng
 * @date ：Created in 14:19 2018/8/24
 * @description：
 */
public class BinoCoeff2 {
  public static void main(String[] args) {
    Integer result = path(1, 2);
    System.out.println(result);
  }

  private static Integer path(Integer n, Integer m) {
    int[][] result = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0) {
          result[i][j] = 1;
        } else {
          result[i][j] = result[i - 1][j] + result[i][j - 1];
        }
      }
    }
    return result[n][m];
  }

  /** 0 1 2 0 0 1 1 1 1 2 3 2 1 3 6 */
  private static int min(int i, int k) {
    return i < k ? i : k;
  }
}
