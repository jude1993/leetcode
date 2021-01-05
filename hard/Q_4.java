import sun.applet.Main;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * todo:
 */
public class Q_4 {

    public static void main(String[] args) {
        Q_4 q = new Q_4();
        double medianSortedArrays = q.findMedianSortedArrays(new int[]{1, 3}, new int[]{2,4,5});
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        boolean hasTwo = len % 2 == 0;
        int mid = len / 2;
        int mid2 = hasTwo ? mid + 1 : mid;

        int v1 = 0, v2 = 0;
        int i = 0;
        int ind1 = 0, ind2 = 0;
        while(true){
            if(ind1 >= nums1.length){
                int index = mid - ind1;
                v1 = nums2[index];
                v2 = hasTwo ? nums2[index + 1] : nums2[index];
                break;
            }
            if(ind2 >= nums2.length){
                int index = mid - ind2;
                v1 = nums1[index];
                v2 = hasTwo ? nums1[index + 1] : nums1[index];
                break;
            }
            if(i == (mid-1) && !hasTwo){
                v1 = Math.min(nums1[ind1], nums2[ind2]);
                v2 = v1;
                break;
            }else if(i == (mid-1)){
                v1 = Math.min(nums1[ind1], nums2[ind2]);
                if(nums1[ind1] > nums2[ind2]){
                    ind2 = ind2 + 1;
                }else{
                    ind1 = ind1 + 1;
                }
            }else if(hasTwo && i == (mid2-1)){
                v2 = Math.min(nums1[ind1], nums2[ind2]);
                break;
            }else{
                if(nums1[ind1] > nums2[ind2]){
                    ind2 = ind2 + 1;
                }else{
                    ind1 = ind1 + 1;
                }
            }
            i = i + 1;
        }
        return (v1 + v2) / 2D;
    }
}
