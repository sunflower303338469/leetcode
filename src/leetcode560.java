import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/7/14.
 */
public class leetcode560 {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) {
                ans++;
            }
            int b = count.getOrDefault(sum - k, 0);
            ans = ans + b;

            int value = count.getOrDefault(sum, 0);
            value++;
            count.put(sum, value);
        }

        return ans;
    }
}
