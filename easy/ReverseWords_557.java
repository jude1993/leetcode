/**
 * @Author: jude
 * @Date: Create in 15:53 2018/3/13
 * @Description:Given a string, you need to reverse the order of characters in each word within a sentence
 *              while still preserving whitespace and initial word order.
 */
public class ReverseWords_557 {
    public String reverseWords(String s){
        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<words.length; i++){
            sb.append(reverseString(words[i]));
            if(i!=words.length-1)
                sb.append(" ");
        }
        return sb.toString();
    }

    private String reverseString(String s){
        char[] chars = s.toCharArray();
        char[] newChar = new char[s.length()];
        for(int i=0; i<chars.length; i++){
            newChar[i] = chars[chars.length-1-i];
        }
        return new String(newChar);
    }


    /**最佳答案*/
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            int index = s.indexOf(' ', i);
            if (index == -1) {
                reverse(chars, i, chars.length - 1);
                break;
            }
            reverse(chars, i, index - 1);
            i = index + 1;
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
