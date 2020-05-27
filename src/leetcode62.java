/**
 * Created by xuanmao on 2020/4/28.
 */
public class leetcode62 {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        f[0][0] = 1;
        for (int i =0;i<m;i++){
            for (int j =0;j<n;j++){
                if (i!=0){
                    f[i][j] += f[i-1][j];
                }
                if (j!=0){
                    f[i][j]+=f[i][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }
}
