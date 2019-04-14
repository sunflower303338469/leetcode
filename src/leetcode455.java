import java.util.Arrays;

/**
 * Created by xuanmao on 2019/3/6.
 */
public class leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int h1 = 0;
        int h2 = 0;
        while (h1 < g.length) {
            while (h2 < s.length) {
                if (s[h2] >= g[h1]) {
                    h2 = h2 + 1;
                    ans += 1;
                    break;
                }
                h2 = h2 + 1;
            }
            if (h2 >= s.length) {
                break;
            }
            h1 = h1 + 1;
        }
        return ans;
    }
}
