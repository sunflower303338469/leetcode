/**
 * Created by xuanmao on 2020/5/31.
 */
public class leetcode1351 {
    public int countNegatives(int[][] grid) {
        if (grid.length==0){
            return 0;
        }
        int ans = 0;
        for (int i =0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j] <0){
                    ans++;
                }
            }
        }
        return ans;
    }
}
