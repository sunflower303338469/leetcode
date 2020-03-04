/**
 * Created by xuanmao on 2020/2/18.
 */
public class leetcode673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int[] f = new int[nums.length];
        int[] c = new int[nums.length];
        f[0] = 1;
        c[0] = 1;
        int max = 1;
        for (int i=1;i<nums.length;i++){
            f[i] = 1;
            c[i] = 1;
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    if (f[i]<f[j]+1){
                        f[i] = f[j]+1;
                        c[i] = c[j];
                    } else if (f[i] == f[j]+1){
                        c[i] += c[j];
                    }
                }
            }
            max = Math.max(max, f[i]);
        }
        int count = 0;
        for (int i=0;i<nums.length;i++){
            if (f[i] == max) {
                count =count+c[i];
            }
        }
        return count;
    }
}
