import java.util.*;

/**
 * @author ：wupeng
 * @date ：Created in 13:57 2019/2/26
 * @description：
 */
public class Repetition<T> {
    //solution 1
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
          for (int j = i + 1; j <= n; j++){
              if (allUnique(s, i, j)){
                  ans = Math.max(ans, j - i);
                }
          }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)){
                return false;
            }
            set.add(ch);
        }
        return true;
    }

  // solution 2
  public int lengthOfLongestSubstring2(String s) {
      Set<Character> set = new HashSet<>();
      int max = 0;
      int temp = 0;
      for(int i=0; i<s.length(); i++){
          temp ++;
          for(int j=i+1; j<=s.length();j++){
              set.add(s.charAt(i));
             if(s.charAt(i) == s.charAt(j==s.length() ? s.length()-1:j) || set.contains(s.charAt(j))){
                 max = Math.max(max,j-i);
                 set.clear();
                 break;
             }else{
                 set.add(s.charAt(j));
             }
          }
      }
      return max;
  }
//"abcabcbbsbcacbbb"
  public static void main(String[] args) {
      Repetition<Comparable> repetition = new Repetition<>();
    int leng = repetition.lengthOfLongestSubstring("dvdf");
    System.out.println(leng);
  }

  private int binarySearch(Comparable<T> [] arr,int start,int end,T target){
        if(start <= end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(arr[mid].compareTo(target) > 0){
            return binarySearch(arr,0,mid,target);
        }
        if(arr[mid].compareTo(target) < 0){
            return binarySearch(arr,mid,end,target);
        }
        if(arr[mid].compareTo(target) == 0){
            return mid;
        }
        return -1;
  }
}
