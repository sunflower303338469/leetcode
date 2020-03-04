/**
 * Created by xuanmao on 2020/2/23.
 */
public class leetcode375 {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 0;
        }
        for (int j = 1; j < n; j++) {
            for (int start = 0; start < n; start++) {
                int end = start + j;
                if (end >= n) {
                    break;
                }
                f[start][end] = Integer.MAX_VALUE;
                for (int k = start; k <= end; k++) {
                    int now = k;
                    int left = k > start ? f[start][k - 1] : 0;
                    int right = k < end ? f[k + 1][end] : 0;
                    f[start][end] = Math.min(f[start][end], now + Math.max(left, right));
                }
            }
        }
        return f[0][n - 1];
    }
}
