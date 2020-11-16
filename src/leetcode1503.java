import java.util.Map;

/**
 * Created by xuanmao on 2020/10/7.
 */
public class leetcode1503 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int i = 0; i < left.length; i++) {
            ans = Math.max(ans, left[i]);
        }
        for (int j = 0; j < right.length; j++) {
            ans = Math.max(ans, n-right[j]);
        }
        return ans;
    }
}
