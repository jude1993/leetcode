package sort;

import java.util.concurrent.*;

/**
 * @author ：wupeng
 * @date ：Created in 16:57 2019/3/26
 * @description：
 */
public class ThreadQuickSort {
    public static void main(String[] args){
        Integer[] integers = {9, 11, 2, 3, 1, 14, 5, 6, 13, 12, 10, 0};
        ThreadQuickSort quickSort = new ThreadQuickSort();
        Long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        try {
            quickSort.quickSort(0,integers.length-1,integers,executor);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
    System.out.println(end - start);
    }

    <T extends Comparable<T>> void quickSort(int l, int r, T[] arr, ExecutorService executor) throws ExecutionException, InterruptedException {
        if(l<r){
            sortTask<T> task = new sortTask<>(l, r, arr);
            Future<Integer> future = executor.submit(task);
            int p = future.get();
            quickSort(l,p-1,arr,executor);
            quickSort(p+1,r,arr,executor);

        }
    }


}

class sortTask<T extends Comparable<T>> implements Callable<Integer> {
    private int s;
    private int e;
    private T[] arr;
    public sortTask(int s, int e,T[] arr){
        this.s = s;
        this.e = e;
        this.arr = arr;
    }
    @Override
    public Integer call() throws InterruptedException {
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
