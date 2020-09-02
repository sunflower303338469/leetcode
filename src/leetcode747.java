/**
 * Created by xuanmao on 2020/7/22.
 */
public class leetcode747 {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int index = -1;
        boolean half = false;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                half = nums[i] >= max * 2;
                max = nums[i];
                index = i;
            } else {
                half = half && (max >= nums[i]*2);
            }
        }
        if (!half) {
            return -1;
        }
        return index;
    }
}
