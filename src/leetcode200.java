import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/4/27.
 */
public class leetcode200 {

    int[] tx = {1,0,-1,0};
    int[] ty = {0,1,0,-1};
    public int numIslands(char[][] grid) {
        if (grid.length==0){
            return 0;
        }
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if ((grid[i][j]=='1') && (!visit[i][j])){
                    visit[i][j] = true;
                    ans++;
                    int l = 0;
                    List<Integer> xList = new ArrayList<>();
                    List<Integer> yList = new ArrayList<>();
                    xList.add(i);
                    yList.add(j);
                    while (l<xList.size()){
                        int x = xList.get(l);
                        int y = yList.get(l);
                        for (int k =0;k<tx.length;k++){
                            int tempX = x+ tx[k];
                            int tempY = y+ ty[k];
                            if ((tempX>=0) && (tempX<grid.length) && (tempY>=0) && (tempY<grid[0].length) && (grid[tempX][tempY]=='1') && (!visit[tempX][tempY])){
                                visit[tempX][tempY] = true;
                                xList.add(tempX);
                                yList.add(tempY);
                            }
                        }
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}
