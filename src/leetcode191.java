/**
 * Created by xuanmao on 2020/7/22.
 */
public class leetcode191 {
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i=0;i<32;i++){
            ans += n & 1;
            n = n>>1;
        }
        return ans;
    }
}
