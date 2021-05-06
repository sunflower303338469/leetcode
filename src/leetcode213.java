/**
 * Created by xuanmao on 2021/4/15.
 */
public class leetcode213 {
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int[][] f = new int[nums.length][2];
        int[][] g = new int[nums.length][2];
        f[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + nums[i];
            g[i][0] = Math.max(g[i - 1][0], g[i - 1][1]);
            g[i][1] = g[i - 1][0] + nums[i];
        }
        return Math.max(Math.max(f[nums.length - 2][0], f[nums.length - 2][1]), Math.max(g[nums.length - 1][0], g[nums.length - 1][1]));
    }
}
