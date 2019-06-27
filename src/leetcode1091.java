import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by xuanmao on 2019/6/16.
 */
public class leetcode1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1){
            return -1;
        }
        int[][] visit = new int[grid.length][grid[0].length];
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        int[] dx = {-1, -1, -1 , 0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        visit[0][0] = 1;
        x.add(0);
        y.add(0);
        int p =0;
        while (p<x.size()){
            int tx=  x.get(p);
            int ty = y.get(p);
            if ((tx==grid.length-1) && (ty==grid[0].length-1)){
                return visit[tx][ty];
            }
            for (int i=0;i<dx.length;i++){
                if ((tx+dx[i]>=0) && (tx+dx[i]<grid.length) && (ty+dy[i]>=0) && (ty+dy[i]<grid[0].length)){
                    if ((visit[tx+dx[i]][ty+dy[i]] == 0) && (grid[tx+dx[i]][ty+dy[i]] ==0)){
                        visit[tx+dx[i]][ty+dy[i]] = visit[tx][ty] +1;
                        x.add(tx+dx[i]);
                        y.add(ty+dy[i]);
                    }
                }
            }
            p++;
        }
        return -1;
    }
}
