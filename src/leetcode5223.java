import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/10/13.
 */
public class leetcode5223 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int [][] p = new int[8][8];
        List<List<Integer>> ans = new ArrayList<>();
        int[] tx = {-1,-1,-1,0,0,1,1,1};
        int[] ty = {-1,0,1,-1,1,-1,0,1};
        boolean[] flag = new boolean[8];
        for (int i=0;i<queens.length;i++){
            p[queens[i][0]][queens[i][1]] = 1;
        }
        if (p[king[0]][king[1]] == 1){
            List<Integer> pos = new ArrayList<>();
            pos.add(king[0]);pos.add(king[1]);
            ans.add(pos);
            return ans;
        }
        int x = king[0];
        int y = king[1];
        for (int k=1;k<=8;k++){
            for (int t = 0;t<8;t++){
                int nowX = x+tx[t] * k;
                int nowY = y+ty[t] * k;
                if ((nowX>=0) && (nowX<8) &&(nowY>=0) && (nowY<8) && (!flag[t])){
                    if (p[nowX][nowY] == 1){
                        List<Integer> pos = new ArrayList<>();
                        pos.add(nowX);pos.add(nowY);
                        ans.add(pos);
                        flag[t] = true;
                    }
                }
            }
        }
        return ans;
    }
}
