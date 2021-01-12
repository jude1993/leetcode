/**
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/
 * 5   7
 * */
public class Q_375 {
    public static void main(String[] args) {
        Q_375 q = new Q_375();
        int moneyAmount = q.getMoneyAmount(10);
        System.out.println(moneyAmount);
    }

    public int getMoneyAmount(int n) {
        return countMemory(n, 0);
    }


    private int countMemory(int n, int b){
        if(b == n){
            return 0;
        }
        if(b + 1 == n){
            return b;
        }
        return b + countMemory(n,(n + b) / 2);
    }
}
