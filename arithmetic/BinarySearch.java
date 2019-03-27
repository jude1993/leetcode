/**
 * @author ：wupeng
 * @date ：Created in 10:28 2019/3/27
 * @description：
 */
public class BinarySearch {
  public static void main(String[] args) {
      Integer[] arr = {1,2,3,4,5,6,7,18,19,23,32,55};
      int position = search(0, arr.length - 1, arr, 5);
      System.out.println(position);
  }

  private static <T extends Comparable<T>> int search(int s, int e, T[] arr,T target){
      if(s > e){
          return -1;
      }
      int mid = (s + e)/2;
      if(target.compareTo(arr[mid]) == 0){
          return mid;
      }
      if(target.compareTo(arr[mid])>0){
          return search(mid+1, e, arr, target);
      }
      if(target.compareTo(arr[mid]) < 0){
          return search(s,mid-1,arr,target);
      }
      return -1;
  }
}
