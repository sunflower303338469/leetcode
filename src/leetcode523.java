import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/2/22.
 */
public class leetcode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
        for (int i = 0; i < nums.length - 1; ++i)
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        if (k == 0) return false;
        if (k < 0) k = -k;
        int[] yushu = new int[nums.length];
        Map<Integer, Integer> hasyushu = new HashMap<>();
        if (nums.length < 1) {
            return false;
        }
        yushu[0] = nums[0] % k;
        hasyushu.put(yushu[0], 1);
        for (int i = 1; i < nums.length; i++) {
            yushu[i] = (yushu[i - 1] + nums[i]) % k;
            if (0 == yushu[i]) {
                return true;
            }
            if (hasyushu.containsKey(yushu[i])) {
                return true;
            }
            hasyushu.put(yushu[i], 1);
        }
        return false;
    }
}
