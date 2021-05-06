/**
 * Created by xuanmao on 2021/3/29.
 */
public class leetcode1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for (int i =0;i<points.length;i++){
            if (points[i][0]==x || points[i][1] == y){
                int dis = Math.abs(x-points[i][0]) + Math.abs(y - points[i][1]);
                if (min>dis){
                    min = dis;
                    ans = i;
                }
            }
        }
        return ans;
    }
}
