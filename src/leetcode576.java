/**
 * Created by xuanmao on 2020/2/26.
 */
public class leetcode576 {

    int MOD = 1000000007;
    int[] tx = {1, 0, -1, 0};
    int[] ty = {0, 1, 0, -1};

    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] f = new int[m][n][N + 1];
        int ans = 0;
        f[i][j][0] = 1;
        for (int step = 0; step < N; step++) {
            for (int ii = 0; ii < m; ii++) {
                for (int jj = 0; jj < n; jj++) {
                    for (int k = 0; k < tx.length; k++) {
                        int tempx = ii + tx[k];
                        int tempy = jj + ty[k];
                        if ((tempx < 0) || (tempx >= m) || (tempy < 0) || (tempy >= n)) {
                            ans = (ans + f[ii][jj][step]) % MOD;
                        } else {
                            f[tempx][tempy][step + 1] = (f[tempx][tempy][step + 1] + f[ii][jj][step]) % MOD;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
