/**
 * Created by xuanmao on 2019/5/16.
 */
public class leetcode836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0],rec2[0]);
        int y = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
        return (x>0) && (y >0);
    }
}
