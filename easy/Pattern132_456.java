import java.util.ArrayList;
import java.util.List;

public class Pattern132_456 {
    public boolean find132pattern(int[] nums) {
        int min = 0;
        int med = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {

        }
        return false;
    }



    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        backtrade("",list,3,3);
        System.out.print(list);
    }

    static void backtrade(String sublist, List<String> res, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sublist);
            return;
        }//左右括号用完
        if (left > 0) {
            backtrade(sublist + "(", res, left - 1, right);
        }//左括号可以用
        if (left < right) {
            backtrade(sublist + ")", res, left, right - 1);
        }
    }
}

