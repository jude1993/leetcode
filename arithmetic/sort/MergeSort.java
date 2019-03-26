package sort;

/**
 * @author ：wupeng
 * @date ：Created in 17:50 2019/3/26
 * @description：
 */
public class MergeSort {
  public static void main(String[] args) {
    //
  }

  public <T extends Comparable<T>> T[] merge(T[] arr1, T[] arr2){
      Object[] total = new Object[arr1.length+arr2.length];
      int a1 = 0;
      int a2 = 0;
      int index = 0;
      while(a1 == arr1.length || a2 == arr2.length){
          if(a1 < arr1.length && arr1[a1].compareTo(arr2[a2]) <= 0){
             total[index] = arr1[a1];
             a1 ++;
          }else if(a2<arr2.length){
             total[index] = arr2[a2];
             a2++;
          }
          index++;
      }
      return null;
  }
}
