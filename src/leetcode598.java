/**
 * Created by xuanmao on 2020/6/10.
 */
public class leetcode598 {
    public int maxCount(int m, int n, int[][] ops) {
        int minm = m;
        int minn = n;
        for (int i =0;i<ops.length;i++){
            minm = Math.min(ops[i][0], minm);
            minn = Math.min(ops[i][1],minn);
        }
        return minm*minn;
    }
}
