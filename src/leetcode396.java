/**
 * Created by xuanmao on 2020/12/1.
 */
public class leetcode396 {
    public int maxRotateFunction(int[] A) {
        int now = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            now += A[i] * i;
            sum += A[i];
        }
        int ans = now;
        for (int i = A.length - 1; i > 0; i--) {
            now = now + sum - A[i] * A.length;
            ans = Math.max(now, ans);
        }
        return ans;
    }
}
