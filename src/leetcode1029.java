/**
 * Created by xuanmao on 2019/4/21.
 */
public class leetcode1029 {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length /2;
        int[][] f = new int[n+1][n+1];
        for (int i=0;i<=n;i++){
            for (int j=0;j<=n;j++){
                f[i][j] = 10000000;
            }
        }
        f[0][0] =0;
        for (int k=0;k<2*n;k++){
            int[] value = costs[k];
            for (int i=n; i>=0;i--){
                for (int j=n;j>=0;j--){
                    if (i-1>=0){
                        f[i][j] = min(f[i-1][j] + value[0], f[i][j]);
                    }
                    if (j-1>=0){
                        f[i][j] = min(f[i][j-1]+value[1], f[i][j]);
                    }
                }
            }
        }
        return f[n][n];
    }
    private int min(int a,int b){
        if (a<b){
            return a;
        }
        return b;
    }
}
