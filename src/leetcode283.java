/**
 * Created by xuanmao on 2020/11/19.
 */
public class leetcode283 {
    public void moveZeroes(int[] nums) {
        int l = 0;
        int r=0;
        while (l<nums.length){
            while (l<nums.length && nums[l]!=0){
                l++;
            }
            if (l>=nums.length){
                return;
            }
            r = Math.max(r, l);
            while (r<nums.length && nums[r]==0){
                r++;
            }
            if (r>=nums.length) {
                return;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
}
