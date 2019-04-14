package notfinish;

/**
 * Created by xuanmao on 2019/3/6.
 */
public class leetcode233 {
    public int countDigitOne(int n) {
        int ans = 0;
        while (n > 0) {
            int p = n % 10;
            ans += n / 10;
            if (p < 1) {
                ans = ans - 1;
            }
            n = n / 10;
        }
        return ans;
    }
}
