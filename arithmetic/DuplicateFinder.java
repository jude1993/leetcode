/**
 * @author ：wupeng
 * @date ：Created in 10:05 2019/2/20
 * @description：
 */
public class DuplicateFinder {
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                printArr(nums);
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    break;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void printArr(int[] nums){
        for(int i=0; i<nums.length; i++){
           System.out.print(nums[i]+" ");
        }
    System.out.println();
    }

  public static void main(String[] args) {
    int[] nums = {2,1,5,3,4,2,1,3};
    int[] duplicate = new int[nums.length];

    DuplicateFinder duplicateFinder = new DuplicateFinder();
    boolean result = duplicateFinder.duplicate(nums, nums.length, duplicate);
    System.out.println(result);
  }
}



