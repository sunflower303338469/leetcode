/**
 * Created by xuanmao on 2019/8/9.
 */
public class t3 {
    public int maxDistance(int[][] grid) {
        int[][] f = new int[grid.length][grid[0].length];
        int[][] g = new int[grid.length][grid[0].length];
        int[][] h = new int[grid.length][grid[0].length];
        int[][] t = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    f[i][j] = 99999999;
                    if (i - 1 >= 0) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    g[i][j] = 99999999;
                    if (i - 1 >= 0) {
                        g[i][j] = Math.min(g[i][j], g[i - 1][j] + 1);
                    }
                    if (j + 1 < grid[0].length) {
                        g[i][j] = Math.min(g[i][j], g[i][j + 1] + 1);
                    }
                }
            }
        }
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    h[i][j] = 99999999;
                    if (i + 1 < grid.length) {
                        h[i][j] = Math.min(h[i][j], h[i + 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        h[i][j] = Math.min(h[i][j], h[i][j - 1] + 1);
                    }
                }
            }
        }
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    t[i][j] = 99999999;
                    if (i + 1 < grid.length) {
                        t[i][j] = Math.min(t[i][j], t[i + 1][j] + 1);
                    }
                    if (j + 1 < grid[0].length) {
                        t[i][j] = Math.min(t[i][j], t[i][j + 1] + 1);
                    }
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int count = Math.min(f[i][j], g[i][j]);
                    count = Math.min(count, h[i][j]);
                    count = Math.min(count, t[i][j]);
                    if (count != 99999999) {
                        ans = Math.max(ans, count);
                    }
                }
            }
        }
        return ans;
    }
}
