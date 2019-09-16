/**
 * Created by xuanmao on 2019/8/8.
 */
public class leetcode695 {

    int[] v;
    int[] tx = {0, 1, 0, -1};
    int[] ty = {-1, 0, 1, 0};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        v = new int[grid.length * grid[0].length + 1];
        int[] count = new int[grid.length * grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    v[i * grid[0].length + j + 1] = i * grid[0].length + j + 1;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int fx = i + tx[k];
                        int fy = j + ty[k];
                        if ((fx >= 0) && (fx < grid.length) && (fy >= 0) && (fy < grid[0].length)) {
                            if (grid[fx][fy] == 1) {
                                int g1 = getFather(i * grid[0].length + j + 1);
                                int g2 = getFather(fx * grid[0].length + fy + 1);
                                if (g1 != g2) {
                                    v[g1] = g2;
                                }
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int fa = getFather(i*grid[0].length+j+1);
                    count[fa]++;
                    ans = Math.max(ans, count[fa]);
                }
            }
        }
        return ans;
    }

    private int getFather(int x) {
        while (v[x] != x) {
            v[x] = v[v[x]];
            x = v[x];
        }
        return v[x];
    }
}
