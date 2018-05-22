import org.junit.jupiter.api.Test;

/**
 * Created by jude on 2018/4/16.
 */
public class ArrayPartition_561 {
    public static int arrayPairSum(int[] nums){
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        int total = 0;
        for(int i=0; i<nums.length; i++){
            if(i/2 == 0){
                total += nums[i];
            }
        }
        return total;
    }

    public static void main(String[] args){
        System.out.println(arrayPairSum(new int[]{1,4,3,2}));
    }
    @Test
    public void test1(){
        System.out.println(arrayPairSum(new int[]{1,4,3,2}));
    }
}
