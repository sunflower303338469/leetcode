import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/4/12.
 */
public class leetcode986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int l = 0;
        int r = 0;
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        while ((l < A.length) && (r < B.length)) {
            int x1 = A[l][0];
            int y1 = A[l][1];
            int x2 = B[r][0];
            int y2 = B[r][1];
            if (y1>y2){
                if (x1<=y2){
                    start.add(Math.max(x1,x2));
                    end.add(y2);
                }
                r++;
            } else if (y1<y2){
                if (x2<=y1){
                    start.add(Math.max(x1,x2));
                    end.add(y1);
                }
                l++;
            } else {
                start.add(Math.max(x1,x2));
                end.add(y1);
                l++;
                r++;
            }
        }
        int[][] ans = new int[start.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i][0] = start.get(i);
            ans[i][1] = end.get(i);
        }
        return ans;
    }
}
