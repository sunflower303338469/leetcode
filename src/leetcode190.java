/**
 * Created by xuanmao on 2021/3/29.
 */
public class leetcode190 {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i =1;i<=32;i++){
            ans = (ans <<1) + (n & 1);
            n = n>>1;
        }
        return ans;
    }
}
