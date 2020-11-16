import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/9/29.
 */
public class leetcode532 {
    public int findPairs(int[] nums, int k) {
        if (k<0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = map.getOrDefault(nums[i], 0);
            if (k == 0) {
                if (value == 1) {
                    ans++;
                }
            } else if (value == 0) {
                if (map.containsKey(nums[i] - k)) {
                    ans++;
                }
                if (map.containsKey(nums[i] + k)) {
                    ans++;
                }
            }
            value++;
            map.put(nums[i], value);
        }
        return ans;
    }
}
