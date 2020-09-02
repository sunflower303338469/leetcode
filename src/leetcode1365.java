/**
 * Created by xuanmao on 2020/8/11.
 */
public class leetcode1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i =0;i<nums.length;i++){
            for (int j =0;j<nums.length;j++){
                if (nums[i]>nums[j]){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
