package sort;

/**
 * @author ：wupeng
 * @date ：Created in 17:50 2019/3/26
 * @description：
 */
public class MergeSort {
  public static void main(String[] args) {
    Integer[] arr1 = {2,4,6,8,10};
    Integer[] arr2 = {1,3,5,7,9};
    Object[] objects = merge(arr1, arr2);
    print(objects);
  }

  private void sort(Comparable[] arr){
      Comparable[] temp = new Comparable[arr.length];
      sort(0,arr.length-1,arr,temp);

  }

  private <T extends Comparable<T>> void sort(int s, int e, T[] arr,Object[] temp){
      if(s < e){
        int mid = (s + e)/2;
        sort(0,mid,arr,temp);
        sort(mid,e,arr,temp);
        //merge();
      }
  }

  public static <T extends Comparable<T>> Object[] merge(T[] arr1, T[] arr2){
      Object[] total = new Object[arr1.length+arr2.length];
      int a1 = 0;
      int a2 = 0;
      int index = 0;
      for(int i=0; i<arr1.length + arr2.length; i++){
          if(a1 >= arr1.length && a2 < arr2.length){
              total[index] = arr2[a2];
              a2 ++;
          }else if(a1 < arr1.length && a2 >= arr2.length){
              total[index] = arr1[a1];
              a1 ++;
          }else if(arr1[a1].compareTo(arr2[a2]) >=0){
              total[index] = arr2[a2];
              a2 ++;
          }else{
              total[index] = arr1[a1];
              a1 ++;
          }
          index++;
      }
      return total;
  }

    private static void print(Object[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
