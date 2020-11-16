/**
 * Created by xuanmao on 2020/11/3.
 */
public class leetcode463 {
    int[] tx = {0,1,0,-1};
    int[] ty = {1,0,-1,0};

    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i =0;i<grid.length;i++){
            for (int j =0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    for (int k = 0;k<tx.length;k++){
                        int tempX = i+tx[k];
                        int tempY = j+ty[k];
                        if ((tempX<0)||(tempX>=grid.length)||(tempY<0)||(tempY>=grid[0].length)){
                            ans++;
                        } else if (grid[tempX][tempY]==0){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
