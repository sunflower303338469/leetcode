/**
 * Created by xuanmao on 2019/8/18.
 */
public class leetcode807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int f[] = new int[grid.length];
        int g[] = new int[grid[0].length];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                f[i] = Math.max(f[i], grid[i][j]);
                g[j] = Math.max(g[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                ans += (Math.min(f[i],g[j]) - grid[i][j]);
            }
        }
        return ans;
    }
}
