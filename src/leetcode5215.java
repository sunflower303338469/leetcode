/**
 * Created by xuanmao on 2019/10/6.
 */
public class leetcode5215 {
    int[][] map;
    boolean[][] vis;
    int ans = 0;
    int[] tx = {0,1,0,-1};
    int[] ty = {1,0,-1,0};
    public int getMaximumGold(int[][] grid) {
        map = grid;
        vis = new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]!=0){
                    vis[i][j] =true;
                    goNode(i,j, grid[i][j]);
                    vis[i][j] =false;
                }
            }
        }
        return ans;
    }

    private void goNode(int x, int y, int nowGold){
        System.out.println(x + " "+ y +" "+ nowGold);
        if (ans<nowGold){
            ans = nowGold;
        }
        for (int i =0;i<4;i++){
            int nx = x+tx[i];
            int ny = y+ty[i];
            if ((nx>=map.length) || (nx<0) || (ny>=map[0].length) || (ny<0)){
                continue;
            }
            if ((map[nx][ny] == 0) || (vis[nx][ny])){
                continue;
            }
            vis[nx][ny] = true;
            goNode(nx,ny, nowGold+map[nx][ny]);
            vis[nx][ny] = false;
        }
    }
}
