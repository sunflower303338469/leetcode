/**
 * Created by xuanmao on 2019/3/6.
 */
public class leetcode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int now = 1;
        int head = 0;
        System.out.println(nums.length);
        for (int i = 0; i < nums.length; i++) {
            now = now * nums[i];
            while ((now >= k) && (head <= i)) {
                now = now / nums[head];
                head += 1;
            }
            if (head <= i) {
                ans += (i - head) + 1;
            }
        }
        return ans;
    }
}
