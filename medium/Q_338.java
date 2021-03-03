public class Q_338 {

    public static void main(String[] args) {
        Q_338 q = new Q_338();
        int[] ints = q.countBits1(6);
        for(int i : ints){
            System.out.println(i);
        }
    }

    //自己答案
    public int[] countBits(int num) {
        int[] arr = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            arr[i] = getBinaryNum(i);
        }
        return arr;
    }


    int getBinaryNum(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        int num = i % 2 == 0 ? 0 : 1;
        return num + getBinaryNum(i / 2);
    }

    //动态规划——最高有效位
    public int[] countBits1(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    //动态规划——最低有效位
    public int[] countBits2(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
