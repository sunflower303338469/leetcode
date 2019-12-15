import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuanmao on 2019/11/11.
 */
public class leetcode645 {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int sum =0;
        Set<Integer> value = new HashSet<>();
        for (int i =0;i<nums.length;i++){
            sum = sum+nums[i];
            if (value.contains(nums[i])){
                ans[0] = nums[i];
            }
            value.add(nums[i]);
        }
        int rightSum = (1+nums.length)*nums.length/2;
        ans[1] = rightSum - sum + ans[0];
        return ans;
    }
}
