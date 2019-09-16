/**
 * Created by xuanmao on 2019/8/12.
 */
public class leetcode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        if (nums.length==0){
            return 0;
        }
        int now = nums[0];
        ans = now;
        for (int i=1;i<nums.length;i++){
            if (nums[i]==0){
                now = 0;
            } else {
                now ++;
                ans = Math.max(ans, now);
            }
        }
        return ans;
    }
}
