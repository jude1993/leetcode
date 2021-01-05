/**
 * @Author: jude
 * @Date: Create in 15:00 2018/3/6
 * @Description: The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *  Given two integers x and y, calculate the Hamming distance.
 */
public class HammingDistance_461 {
    public int solution(int x, int y){
        int num = x ^ y;
        int j = 0;
        while(num > 0){
            if(num%2 == 1){
                j++;
            }
            num /= 2;
        }
        return j;
    }
}
