import java.util.Date;

/**
 * Created by xuanmao on 2020/1/13.
 */
public class leetcode611 {
    public int triangleNumber(int[] nums) {
        int[] count = new int[1001];
        int[] sum = new int[1001];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                count[nums[i]]++;
            }
        }
        sum[0] = count[0];
        for (int i = 1; i < 1001; i++) {
            sum[i] = sum[i - 1] + count[i];
        }
        int ans = 0;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if ((nums[i]==0) || (nums[j]==0)){
                    continue;
                }
                int l = Math.abs(nums[i]-nums[j])+1;
                int r = Math.min(1000, nums[i]+nums[j]-1);
                if (r<=0){
                    continue;
                }
                int value = sum[r] - sum[l-1];
                if ((nums[i]>=l) && (nums[i]<=r)){
                    value--;
                }
                if ((nums[j]>=l) && (nums[j]<=r)){
                    value--;
                }
                ans +=value;
            }
        }
        return ans/3;
    }

}
