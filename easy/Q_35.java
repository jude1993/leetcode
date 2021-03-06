public class Q_35 {
    public static void main(String[] args) {
        Q_35 q = new Q_35();
        int i = q.searchInsert(new int[]{0, 2, 3, 4}, 1);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        if(nums[0] >= target){
            return 0;
        }
        if(nums[nums.length -1] < target){
            return nums.length;
        }
        return search(nums, 0, nums.length, target);
    }

    private int search(int[] nums, int startIndex, int endIndex, int target) {
        if (startIndex == endIndex || endIndex - startIndex == 1) {
            return endIndex;
        }

        int index = (startIndex + endIndex) / 2;
        if (nums[index] == target) {
            return index;
        } else if (nums[index] > target) {
            return search(nums, startIndex, index, target);
        } else if (nums[index] < target) {
            return search(nums, index, endIndex, target);
        }
        return -1;
    }
}
