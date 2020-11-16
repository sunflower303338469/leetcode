/**
 * Created by xuanmao on 2020/10/25.
 */
public class leetcode883 {
    public int projectionArea(int[][] grid) {
        int ans = 0;
        int[] a = new int[grid.length];
        int[] b = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    ans++;
                }
                a[i] = Math.max(a[i], grid[i][j]);
                b[j] = Math.max(b[j], grid[i][j]);
            }
        }
        for (int i =0;i<grid.length;i++){
            ans+=a[i];
        }
        for (int j=0;j<grid[0].length;j++){
            ans+=b[j];
        }
        return ans;
    }
}
