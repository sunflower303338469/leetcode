import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/5/21.
 */
public class leetcode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int x = newInterval[0];
        int y = newInterval[1];
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        boolean notInList = true;
        for (int i=0;i<intervals.length;i++){
            int tx = intervals[i][0];
            int ty = intervals[i][1];
            if (ty<x){
                xList.add(tx);
                yList.add(ty);
            } else if (ty == x) {
                x= tx;
            } else if (tx == y){
                y = ty;
            } else if (tx > y){
                if (notInList){
                    xList.add(x);
                    yList.add(y);
                    notInList = false;
                }
                xList.add(tx);
                yList.add(ty);
            } else {
                x = Math.min(tx, x);
                y = Math.max(ty, y);
            }
        }
        if (notInList){
            xList.add(x);
            yList.add(y);
        }
        int [][] ans = new int[xList.size()][2];
        for (int i=0;i<xList.size();i++){
            ans[i][0] = xList.get(i);
            ans[i][1] = yList.get(i);
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
        return ans;
    }
}
