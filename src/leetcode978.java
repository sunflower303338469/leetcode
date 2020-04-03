/**
 * Created by xuanmao on 2020/3/4.
 */
public class leetcode978 {

    public int maxTurbulenceSize(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int[][] f = new int[2][A.length];
        int ans = 1;
        f[0][0] = 1;
        f[0][1] = 1;
        for (int i = 1; i < A.length; i++) {
            f[0][i] = 1;
            f[1][i] = 1;
            if (A[i] < A[i - 1]) {
                f[0][i] = f[1][i - 1] + 1;
            } else if (A[i] > A[i - 1]) {
                f[1][i] = f[0][i - 1] + 1;
            }
            ans = Math.max(ans, f[0][i]);
            ans = Math.max(ans, f[1][i]);
        }
        return ans;
    }
}
