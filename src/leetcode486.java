/**
 * Created by xuanmao on 2020/8/12.
 */
public class leetcode486 {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length%2==0){
            return true;
        }
        int[][][] f = new int[2][nums.length][nums.length];
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            f[0][i][i] = nums[i];
            sum +=nums[i];
        }
        for (int k = 1;k<nums.length;k++){
            for (int i=0;i<nums.length;i++){
                if (i+k>=nums.length){
                    continue;
                }
                f[0][i][i+k] = Math.max(f[1][i][i+k-1] + nums[i+k], f[1][i+1][i+k]+nums[i] );
                f[1][i][i+k] = Math.min(f[0][i][i+k-1] , f[0][i+1][i+k]);
            }
        }
        return f[0][0][nums.length-1]>=sum-f[0][0][nums.length-1];
    }
}
