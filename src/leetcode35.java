/**
 * Created by xuanmao on 2020/7/23.
 */
public class leetcode35 {
    public int searchInsert(int[] nums, int target) {

        int l = 0;
        if (nums[0]>=target){
            return 0;
        }
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l+1;
    }
}
