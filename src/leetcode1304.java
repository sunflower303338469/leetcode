/**
 * Created by xuanmao on 2020/2/11.
 */
public class leetcode1304 {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int k = 0;
        for (int i=1;i<=n/2;i++){
            ans[k] = i;
            ans[k+1] = -i;
            k = k+2;
        }
        return ans;
    }
}
