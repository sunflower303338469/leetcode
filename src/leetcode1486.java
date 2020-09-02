/**
 * Created by xuanmao on 2020/7/14.
 */
public class leetcode1486 {
    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i=0;i<n;i++){
            ans = ans ^ (start+i*2);
        }
        return ans;
    }
}
