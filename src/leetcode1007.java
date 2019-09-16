/**
 * Created by xuanmao on 2019/9/4.
 */
public class leetcode1007 {
    public int minDominoRotations(int[] A, int[] B) {
        int MAX = 999999;
        int[][] f = new int[7][A.length];
        int[][] g = new int[7][A.length];
        for (int i = 1; i <= 6; i++) {
            f[i][0] = MAX;
            g[i][0] = MAX;
        }
        f[B[0]][0] = 1;
        f[A[0]][0] = 0;
        g[A[0]][0] = 1;
        g[B[0]][0] = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j <= 6; j++) {
                f[j][i] = MAX;
                g[j][i] = MAX;
                if (A[i] == j) {
                    f[j][i] = Math.min(f[j][i], f[j][i - 1]);
                    g[j][i] = Math.min(g[j][i], g[j][i - 1] + 1);
                }
                if (B[i] == j) {
                    f[j][i] = Math.min(f[j][i], f[j][i - 1]+1);
                    g[j][i] = Math.min(g[j][i], g[j][i - 1]);
                }
            }
        }
        int ans = MAX;
        for (int i=1;i<=6;i++){
            ans = Math.min(ans, f[i][A.length-1]);
            ans = Math.min(ans, g[i][A.length-1]);
        }
        if (ans == MAX){
            return -1;
        }
        return ans;
    }
}
