/**
 * Created by xuanmao on 2019/5/23.
 */
public class leetcode643 {
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        double ans =-999999999;
        sum[0] =nums[0];
        for (int i=1;i<nums.length;i++){
            sum[i] = sum[i-1] + nums[i];
        }
        ans = (double) sum[k-1] / k;
        for (int i=k;i<nums.length;i++){
            double avg = ((double) (sum[i]-sum[i-k]) / k);
            ans = Math.max(ans, avg);
        }
        return ans;
    }
}
