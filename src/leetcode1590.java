import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/9/23.
 */
public class leetcode1590 {
    public int minSubarray(int[] nums, int p) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int[] mod = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % p;
            mod[i] = sum;
        }
        if (sum == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            map.put(mod[i], i);
            int x = (mod[i] - sum + p) % p;
            Integer index = map.get(x);
            if (index != null) {
                ans = Math.min(ans, i - index);
            }
        }
        return ans < nums.length ? ans : -1;
    }
}
