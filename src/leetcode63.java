/**
 * Created by xuanmao on 2020/8/12.
 */
public class leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length==0){
            return 0;
        }
        if (obstacleGrid[0][0]==1){
            return 0;
        }
        int[][] f = new int[obstacleGrid.length][obstacleGrid[0].length];
        f[0][0] = 1;
        for (int i =0;i<obstacleGrid.length;i++){
            for (int j=0;j<obstacleGrid[0].length;j++){
                if (obstacleGrid[i][j]==1){
                    continue;
                }
                if (i-1>=0){
                    f[i][j] +=f[i-1][j];
                }
                if (j-1>=0){
                    f[i][j]+=f[i][j-1];
                }
            }
        }
        return f[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
