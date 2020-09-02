import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/6/8.
 */
public class leetcode1020 {
    int[] tx = {0,1,0,-1};
    int[] ty = {1,0,-1,0};

    public int numEnclaves(int[][] A) {
        if (A.length==0){
            return 0;
        }
        boolean[][] visit = new boolean[A.length][A[0].length];
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        for (int i =0;i<A.length;i++){
            if (A[i][0] == 1){
                xList.add(i);
                yList.add(0);
                visit[i][0] = true;
            }
            if (A[i][A[0].length-1]==1){
                xList.add(i);
                yList.add(A[0].length-1);
                visit[i][A[0].length-1] = true;
            }
        }
        for (int j =0;j<A[0].length;j++){
            if (A[0][j] == 1){
                xList.add(0);
                yList.add(j);
                visit[0][j] = true;
            }
            if (A[A.length-1][j]==1){
                xList.add(A.length-1);
                yList.add(j);
                visit[A.length-1][j] = true;
            }
        }
        int l = 0;
        while (l<xList.size()){
            int nowX = xList.get(l);
            int nowY = yList.get(l);
            for (int i=0;i<tx.length;i++){
                int tempX = nowX+tx[i];
                int tempY = nowY+ty[i];
                if ((tempX<0) || (tempX>=A.length) || (tempY<0) || (tempY>=A[0].length)){
                    continue;
                }
                if ((A[tempX][tempY]==1) && (!visit[tempX][tempY])){
                    xList.add(tempX);
                    yList.add(tempY);
                    visit[tempX][tempY] = true;
                }
            }
            l++;
        }
        int ans = 0;
        for (int  i=0;i<A.length;i++){
            for (int j =0;j<A[0].length;j++){
                if ((A[i][j]==1) && (!visit[i][j])){
                    ans ++;
                }
            }
        }
        return ans;
    }
}
