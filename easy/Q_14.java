/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Q_14 {
    public static void main(String[] args) {
        Q_14 q = new Q_14();
        String[] arr = new String[]{"flo44", "flee","florr"};
        String s = q.longestCommonPrefix(arr);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].length() == i || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
