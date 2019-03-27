package sort;

/**
 * @author ：wupeng
 * @date ：Created in 10:11 2019/3/27
 * @description：
 */
public class QuickSort2 {
  public static void main(String[] args) {
      Integer[] integers = {9, 11, 2, 3, 1, 14, 5, 6, 13, 12, 10, 0,0};
      QuickSort2 sort = new QuickSort2();
      sort.quickSort(0,integers.length-1,integers);
      print(integers);
  }

  private <T extends Comparable<T>> void quickSort(int s, int e, T[] arr){
      if(s < e){
          int position = sort(s, e, arr);
          quickSort(position+1,e,arr);
          quickSort(s,position-1,arr);
      }
  }

  private <T extends Comparable<T>> int sort(int s, int e, T[] arr){
      int start = s;
      int end = e;
      while(start < end){
          if(arr[start].compareTo(arr[s])>0){
              exchange(start,end,arr);
              end --;
          }else{
              start++;
          }
      }
      if(arr[start].compareTo(arr[s])>=0){
          start --;
      }
      exchange(start,s,arr);
      return start;
  }

    private <T> void exchange(int i, int j, T[] arr){
      T t = arr[i];
      arr[i] = arr[j];
      arr[j] = t;
    }

    private static void print(Object[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
