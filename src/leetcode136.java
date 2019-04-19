import java.util.regex.Pattern;

/**
 * Created by xuanmao on 2019/4/19.
 */
public class leetcode136 {
    public int singleNumber(int[] nums) {
        int ans =0;
        for (int i =0;i<nums.length;i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
