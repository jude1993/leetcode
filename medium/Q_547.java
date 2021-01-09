import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode-cn.com/problems/number-of-provinces/
 * 输入：isConnected = {{1,1,0},{1,1,0},{0,0,1}}
 * 输出：2
 * 输入：isConnected = {{1,0,0},{0,1,0},{0,0,1}}
 * 输出：3
 * {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}
 */
public class Q_547 {

    public static void main(String[] args) {
        Q_547 q = new Q_547();
        int circleNum = q.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}});
        System.out.println(circleNum);
    }

    //广度优先
    //todo:
    public Integer findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < provinces; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                circles++;
            }
        }
        return circles;
    }

    //深度优先
    public Integer findCircleNum_2(int[][] isConnected) {
        if (isConnected.length == 0) {
            return 0;
        }

        int count = 0;
        boolean[] hasVisit = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!hasVisit[i]) {
                search(isConnected, hasVisit, i);
                count = count + 1;
            }
        }
        return count;
    }

    private void search(int[][] arr, boolean[] hasVisit, Integer i) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[i][j] > 0 && !hasVisit[j]) {
                hasVisit[j] = true;
                search(arr, hasVisit, j);
            }
        }
    }


}
