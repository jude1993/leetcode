import org.apache.commons.lang3.StringUtils;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * haystack = "hello", needle = "ll"
 * 2
 *
 * "mississippi"
 * "issipi"
 */
public class Q_28 {

    public static void main(String[] args) {
        Q_28 q = new Q_28();
        int i = q.strStr("mississippi", "issip");
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        if(needle.length() > haystack.length()){
            return -1;
        }
        int index = -1;
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                index = index == -1 ? i : index;
                if (j == needle.length() - 1) {
                    return index;
                }
                j = j + 1;
            } else {
                i = index == -1 ? i : index;
                index = -1;
                j=0;
            }
        }
        return -1;
    }


}
