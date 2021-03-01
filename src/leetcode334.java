/**
 * Created by xuanmao on 2020/11/20.
 */
public class leetcode334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length<3){
            return false;
        }
        int first = nums[0];
        int secord = Integer.MAX_VALUE;
        for (int i =0;i<nums.length;i++){
            first = Math.min(first, nums[i]);
            if (first<nums[i]){
                secord = Math.min(secord, nums[i]);
            }
            if (secord<nums[i]){
                return true;
            }
        }
        return false;
    }
}
