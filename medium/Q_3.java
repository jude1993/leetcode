import java.util.*;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Q_3 {

    public static void main(String[] args) {
        String s = "dvdfac";

        Q_3 q = new Q_3();
        int i = q.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int index = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (index < s.length()) {
            for (int i = index; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    len = Math.max(map.size(), len);
                    index = map.get(c) + 1;
                    map = new HashMap<>();
                    break;
                }
                map.put(c, i);
                index = i + 1;
            }
        }
        len = Math.max(len, map.size());
        return len;
    }

    public int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
