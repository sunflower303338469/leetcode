/**
 * Created by xuanmao on 2021/1/13.
 */
public class leetcode1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int now = Integer.MAX_VALUE;
        for (int i =0;i<nums.length;i++){
            if (nums[i]==1){
                if (now<k){
                    return false;
                }
                now = 0;
            } else {
                if (now!=Integer.MAX_VALUE){
                    now++;
                }
            }
        }

        return true;
    }
}
