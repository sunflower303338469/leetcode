import java.util.HashSet;

/**
 * Created by xuanmao on 2020/6/11.
 */
public class leetcode128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int ans = 0;
        for (Integer value : set) {
            if (set.contains(value - 1)) {
                continue;
            }
            int count = 1;
            while (set.contains(value + 1)) {
                value = value + 1;
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
