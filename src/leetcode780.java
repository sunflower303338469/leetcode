/**
 * Created by xuanmao on 2019/1/25.
 */
public class leetcode780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while ((tx>0) && (ty>0)){
            if ((sx == tx) && (sy == ty)){
                return true;
            }
            if (tx > ty){
                tx = tx - ty;
            }
            else {
                ty = ty - tx;
            }
        }
        return false;
    }
}
