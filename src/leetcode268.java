/**
 * Created by xuanmao on 2019/7/23.
 */
public class leetcode268 {
    public int missingNumber(int[] nums) {
        int ans = (nums.length+1) * nums.length /2;
        for (int i=0;i<nums.length;i++){
            ans = ans - nums[i];
        }
        return ans;
    }
}
