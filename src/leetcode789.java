/**
 * Created by xuanmao on 2020/9/11.
 */
public class leetcode789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dis =  getDis(0,0, target[0],target[1]);
        for (int  i=0;i<ghosts.length;i++){
            if (dis>=getDis(target[0],target[1], ghosts[i][0], ghosts[i][1])){
                return false;
            }
        }
        return true;
    }

    private int getDis(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}
