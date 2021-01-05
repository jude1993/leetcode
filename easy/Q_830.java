import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * https://leetcode-cn.com/problems/positions-of-large-groups/
 * */
public class Q_830 {
    public static void main(String[] args) {
        Q_830 q = new Q_830();
        List<List<Integer>> a = q.largeGroupPositions("abcdddeeeeaabbbcd");
        System.out.println(a);
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new LinkedList<>();
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                if ((i - a) >= 2) {
                    List<Integer> arr = Arrays.asList(a, i);
                    list.add(arr);
                }
            } else {
                char c = s.charAt(i);
                char c1 = s.charAt(i + 1);
                if (c != c1) {
                    if ((i - a) >= 2) {
                        List<Integer> arr = Arrays.asList(a, i);
                        list.add(arr);
                    }
                    a = i + 1;
                }
            }
        }
        return list;
    }
}
