/**
 * Created by xuanmao on 2020/9/28.
 */
public class leetcode1513 {

    public int numSub(String s) {
        long count = 0;
        int mod = 1000000007;
        Long ans = 0L;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                ans = (ans + suan(count)) % mod;
                count = 0;
            }
        }
        ans = (ans + suan(count)) % mod;
        return ans.intValue();
    }

    private long suan(long num) {
        return (num + 1) * num / 2;
    }
}
