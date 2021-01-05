import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Q_20 {
    public static void main(String[] args) {
        Q_20 q = new Q_20();
        boolean flag = q.isValid("{[]}");
        System.out.println(flag);
    }

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> cs = new Stack<>();
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if(map.containsKey(c1)){
                cs.push(c1);
            }else if(!cs.isEmpty()){
                Character pop = cs.pop();
                if(!map.get(pop).equals(c1)){
                    return false;
                }
            }else{
                return false;
            }
        }
        return cs.isEmpty();
    }
}
