/**
 * Created by xuanmao on 2019/6/6.
 */
public class leetcode223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = 0;
        sum = (C-A) * (D-B) + (G-E) * (H-F);
        int yMax = Math.min(D,H);
        int yMin = Math.max(B,F);
        int xMax = Math.min(C,G);
        int xMin = Math.max(A,E);
        if ((yMin<yMax) && (xMin<xMax)){
            sum = sum - (yMax-yMin) * (xMax-xMin);
        }
        return sum;
    }
}
