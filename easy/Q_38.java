public class Q_38 {
    public static void main(String[] args) {
        Q_38 q = new Q_38();
        String s = q.countAndSay(12);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        return transform("1", n -1);
    }

    private String transform(String num, int n) {
        if (n == 0) {
            return num;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        char t = num.charAt(0);

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if(c == t){
                count = count + 1;
            }else{
                sb.append(count).append(t);
                count = 1;
                t = c;
            }
            if(i == num.length() - 1){
                sb.append(count).append(t);
            }
        }
        return transform(sb.toString(), n - 1);
    }
}
