package sort;

/**
 * @author ：wupeng
 * @date ：Created in 14:15 2019/3/26
 * @description：快排
 */
public class QuickSort {
    public static void main(String[] args){
        Integer[] integers = {9, 11, 2, 3, 1, 14, 5, 6, 13, 12, 10, 0};
        QuickSort quickSort = new QuickSort();
        print(integers);
        Long start = System.currentTimeMillis();
        quickSort.quickSort(0,integers.length-1,integers);
        Long end = System.currentTimeMillis();
    System.out.println((end-start));
    }

    private <T extends Comparable<T>> int sort(int s, int e,T[] arr) throws InterruptedException {
        int start = s+1;
        int end = e;
        while(start < end){
            if(arr[s].compareTo(arr[start])<0){
                exchange(start,end,arr);
                print(arr);
                end -- ;
            }else{
                start++;
            }
        }
        if(arr[start].compareTo(arr[s])>0){
            start --;
        }
        exchange(start,s,arr);
        print(arr);
        Thread.sleep(100L);
        return start;
    }

    <T extends Comparable<T>> void quickSort(int l, int r, T[] arr){
        if(l<r){
            try {
                int p = sort(l,r,arr);
                quickSort(l,p-1,arr);
                quickSort(p+1,r,arr);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void exchange(int i, int j, Object[] arr){
        Object a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }

    private static void print(Object[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
