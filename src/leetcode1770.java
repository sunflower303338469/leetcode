/**
 * Created by xuanmao on 2021/3/16.
 */
public class leetcode1770 {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] f = new int[multipliers.length+1][multipliers.length+1];
        for (int i=1;i<=multipliers.length;i++){

            for (int j=0;j<=i;j++){
                if (j==0){
                    f[i][j] = f[i-1][j] + multipliers[i-1]*nums[nums.length-(i-j)];  //选后面
                } else if (j == i){
                    f[i][j]  =f[i-1][j-1] + multipliers[i-1]*nums[j-1];  //选前面
                } else  {
                    f[i][j] = Math.max(f[i-1][j] + multipliers[i-1]*nums[nums.length-(i-j)], f[i-1][j-1] + multipliers[i-1]*nums[j-1]);
                }
                System.out.println(f[i][j]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int  i=0;i<=multipliers.length;i++){
            ans = Math.max(f[multipliers.length][i], ans);
        }
        return ans;
    }
}
