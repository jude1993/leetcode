import java.util.*;
import java.util.stream.Stream;

/**
 * @Author: jude
 * @Date: Create in 16:14 2018/3/13
 * @Description:Given a List of words, return the words that can be typed using letters of alphabet
 * on only one row's of American keyboard like the image below.
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 */
public class KeyboardRow_500 {
    public String[] findWords(String[] words) {
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        Set<String> set3 = new HashSet<String>();
        Collections.addAll(set1, "q", "w", "e", "r", "t", "y", "u", "i", "o", "p");
        Collections.addAll(set2, "a", "s", "d", "f", "g", "h", "j", "l", "l");
        Collections.addAll(set3, "z", "x", "c", "v", "b", "n", "m");
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                //:TODO:
            }
        }
        return null;
    }

    /**
     * 简洁
     */
    public String[] findWords2(String[] words) {
        return Stream.of(words).
                filter(s -> s.toLowerCase()
                        .matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }

    /**
     * 高效
     */
    public String[] findWords3(String[] words) {
        String[] rows =
                {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        String[] returnArr = new String[words.length];
        int i;
        int j;
        int k;
        int l;
        boolean charFlag;
        boolean rowFlag;
        int row;
        for (i = 0; i < words.length; i++) {
            row = -1;
            rowFlag = false;
            charFlag = false;
            char[] cArr = words[i].toCharArray();
            for (j = 0; j < cArr.length; j++) {
                char currentChar = cArr[j];
                // find out which row to check based on initial character
                if (j == 0) {
                    for (k = 0; k < rows.length; k++) {
                        char[] workingRow = rows[k].toCharArray();
                        for (l = 0; l < workingRow.length; l++) {
                            if (currentChar == workingRow[l] || (char) (currentChar + 32) == workingRow[l]) {
                                rowFlag = true;
                                row = k;
                                break;
                            }
                        }
                        if (rowFlag) {
                            break;
                        }
                    }
                }
                if (!rowFlag) {
                    break;
                }
                // After establishing row, check to see if other characters are
                // in it
                else {
                    charFlag = false;
                    char[] workingRow = rows[row].toCharArray();
                    for (l = 0; l < workingRow.length; l++) {
                        if (currentChar == workingRow[l] || (char) (currentChar + 32) == workingRow[l]) {
                            charFlag = true;
                            break;
                        }
                    }
                    if (!charFlag) {
                        break;
                    }
                }

            }
            if (charFlag && rowFlag) {
                returnArr[i] = words[i];
            }
        }
        ArrayList<String> list = new ArrayList<>();
        int counter;
        for (counter = 0; counter < returnArr.length; counter++) {
            if (returnArr[counter] != null) {
                list.add(returnArr[counter]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
