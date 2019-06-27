/**
 * Created by xuanmao on 2019/6/18.
 */
public class leetcode741 {
    public int cherryPickup(int[][] grid) {
        int f[][][] = new int[grid.length][grid.length][grid.length];
        int[] x = {-1, 0};
        int[] y = {0, -1};
        f[0][0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                boolean enable = false;
                for (int k = 0; k < grid.length; k++) {
                    int t = i + j - k;
                    if ((t >= 0) && (t < grid.length)) {
                        for (int apath = 0; apath < x.length; apath++) {
                            for (int bpath = 0; bpath < x.length; bpath++) {
                                if ((i + x[apath] >= 0) && (j + y[apath] >= 0) && (k + x[bpath] >= 0) && (t + y[bpath] >= 0)) {
                                    if ((grid[i + x[apath]][j + y[apath]] != -1) && (grid[k + x[bpath]][t + y[bpath]] != -1)) {
                                        int value = f[i + x[apath]][j + y[apath]][k + x[bpath]] + grid[i][j] + grid[k][t];
                                        if ((i == k) && (j == t)) {
                                            value = value - grid[i][j];
                                        }
                                        f[i][j][k] = Math.max(f[i][j][k], value);
                                        enable = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if ((!enable) && ((i != 0) || (j != 0))) {
                    grid[i][j] = -1;
                }
            }
        }
        return f[grid.length - 1][grid.length - 1][grid.length - 1];
    }
}
