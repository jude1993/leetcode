import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/smallest-string-with-swaps/
 * bacd
 * */
public class Q_1202 {
    public static void main(String[] args) {
        Q_1202 q = new Q_1202();
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0,2));
        String str = q.smallestStringWithSwaps("dcab", lists);
        System.out.println(str);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] arr = s.toCharArray();
        for(List<Integer> l : pairs){
            if(arr[l.get(0)] <= arr[l.get(1)]){
                continue;
            }
            for(List<Integer> j : pairs){
                char temp = arr[j.get(0)];
                arr[j.get(0)] = arr[j.get(1)];
                arr[j.get(1)] = temp;
            }
        }
        return String.valueOf(arr);
    }
}
