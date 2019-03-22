/**
 * @author ：wupeng
 * @date ：Created in 13:44 2019/2/20
 * @description：
 *      [
 *        [1, 4, 7, 11, 15],
 *        [2, 5, 8, 12, 19],
 *        [3, 6, 9, 16, 22],
 *        [10, 13, 14, 17, 24],
 *        [18, 21, 23, 26, 30]
 *      ]
 */
public class ArrayFinder {
    public boolean find(int[][] arr,int a, int b,int target){
        if(a<0 || b <0 || a >= arr.length || b >= arr[0].length){
            return false;
        }
        if(arr[a][b] == target){
            System.out.println(a+" "+b);
            return true;
        }
        if(arr[a][b] > target){
            b = b-1;
            return find(arr,a,b,target);
        }
        if(arr[a][b] < target){
            a = a + 1;
            return find(arr,a,b,target);
        }
        return false;
    }

    public boolean find2(int[][] arr, int target){
        int a = 0;
        int b = arr[0].length;
        while(b > 0){
            if(a < 0 || a >= arr.length || b >= arr[0].length){
                return false;
            }
            if(arr[a][b] == target){
                return true;
            }
            if(arr[a][b] < target){
                a = a + 1;
            }
            if(arr[a][b] > target){
                b = b-1;
            }
        }
        return false;
    }

  public static void main(String[] args) {
        int[][] arr = {{1, 4, 7, 11, 15},{2, 5, 8, 12, 19},{3, 6, 9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
      ArrayFinder finder = new ArrayFinder();

      System.out.println(finder.find(arr,0,arr.length-1,14));
    System.out.println(finder.find2(arr,14));
  }

}
