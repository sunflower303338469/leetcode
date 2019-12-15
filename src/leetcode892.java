/**
 * Created by xuanmao on 2019/12/9.
 */
public class leetcode892 {

    int[] tx = {1,-1,0,0};
    int[] ty = {0,0,-1,1};

    public int surfaceArea(int[][] grid) {
        int count = 0;
        int n = grid.length;
        for (int i =0;i<n;i++){
            for (int j =0;j<n;j++){
                count = count+grid[i][j] * 6;
            }
        }
        for (int i =0;i<n;i++){
            for (int j =0;j<n;j++){
                if (grid[i][j]==0){
                    continue;
                }
                count  = count - (grid[i][j]-1)*2;
                for (int k=0;k<tx.length;k++){
                    int ti = i+tx[k];
                    int tj = j+ty[k];
                    if ((ti>=0) && (tj>=0) && (ti<n) && (tj<n)){
                        int min = Math.min(grid[i][j],grid[ti][tj]);
                        count = count - min;
                    }
                }
            }
        }
        return count;
    }
}
