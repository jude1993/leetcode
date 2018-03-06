import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jude
 * @Date: Create in 15:11 2018/3/6
 * @Description: 判断R (Right)和L (Left), U (Up)和D (down)数量是否相等
 */
public class JudgeRouteCircle {
    public boolean solution(String moves){
        char[] chars = moves.toCharArray();
        int x = 0;
        int y = 0;
        for(char c : chars){
            switch (c){
                case 'R' : x++;
                    break;
                case 'L' : x--;
                    break;
                case 'U' : y++;
                    break;
                case 'D' : y--;
                    break;
            }
        }
        return x==0 && y==0;
    }
}
