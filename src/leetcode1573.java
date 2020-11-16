/**
 * Created by xuanmao on 2020/9/23.
 */
public class leetcode1573 {
    public int numWays(String s) {
        int mod = 1000000007;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        if (count == 0) {
            if (s.length() < 3) {
                return 0;
            }
            Long ans = 1L;
            ans = (ans * (s.length() - 1) * (s.length() - 2) / 2) % mod;
            return ans.intValue();
        } else if (count % 3 != 0) {
            return 0;
        }
        count = count / 3;
        int l = -1;
        int[] a = new int[2];
        int v = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                v++;
                if (v == count) {
                    v = 0;
                    l++;
                }
            } else if (v == 0) {
                if ((l >= 0) && (l < 2)) {
                    a[l]++;
                }
            }
        }
        Long ans = ((a[0] + 1L) * (a[1] + 1)) % mod;
        return ans.intValue();
    }
}
