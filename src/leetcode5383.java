/**
 * Created by xuanmao on 2020/4/12.
 */
public class leetcode5383 {
    int mod = 1000000007;
    int[][] p ={
            {1,2,4,5,10},
            {0,3,6,8,11},
            {1,3,6,7},
            {1,2,7,10},
            {0,6,8,9},
            {0,6,7,9,10},
            {1,2,4,5,11},
            {2,3,5,11},
            {1,4,9,10},
            {4,5,8,11},
            {0,3,5,8,11},
            {1,6,7,9,10}
    };
    public int numOfWays(int n) {
        int[][] f = new int[12][n];
        for (int i =0;i<12;i++){
            f[i][0]=  1;
        }
        for (int  i =1;i<n;i++){
            for (int j =0;j<12;j++){
                f[j][i] = 0;
                for (int k =0;k<p[j].length;k++){
                    f[j][i] = (f[j][i] + f[p[j][k]][i-1]) % mod;
                }
            }
        }
        int ans = 0;
        for (int i=0;i<12;i++){
            ans = (ans + f[i][n-1]) % mod;
        }
        return ans;
    }
}
