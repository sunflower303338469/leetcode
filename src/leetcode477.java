/**
 * Created by xuanmao on 2019/12/10.
 */
public class leetcode477 {
    public int totalHammingDistance(int[] nums) {
        int[][] a = new int[50][2];
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<50;j++){
                a[j][nums[i]%2]++;
                nums[i] = nums[i]/2;
            }
        }
        int ans = 0;
        for (int i=0;i<50;i++){
            ans= ans + a[i][0]*a[i][1];
        }
        return ans;
    }
}
