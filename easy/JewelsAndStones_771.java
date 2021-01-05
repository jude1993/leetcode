import java.util.HashSet;
import java.util.Set;

/**
 * @Author: jude
 * @Date: Create in 14:31 2018/3/6
 * @Description:You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class JewelsAndStones_771 {
    public int solution(String J,String S){
        char[] jewels = J.toCharArray();
        Set<Character> characters = new HashSet<Character>();
        for(char c : jewels){
            characters.add(c);
        }
        char[] stons = S.toCharArray();
        int num = 0;
        for(int i=0; i<stons.length; i++){
            if(characters.contains(stons[i])){
                num ++;
            }
        }
        return num;
    }
}
