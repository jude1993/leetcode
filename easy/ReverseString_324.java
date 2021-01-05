/**
 * @Author: jude
 * @Date: Create in 15:37 2018/3/13
 * @Description: Write a function that takes a string as input and returns the string reversed.
 */
public class ReverseString_324 {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverseString2(String s) {
        char[] charArray = s.toCharArray();
        char[] charArray_2 = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            charArray_2[charArray_2.length-i-1] = charArray[i];
        }
        return new String(charArray_2);
    }
}
