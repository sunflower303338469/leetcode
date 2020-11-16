/**
 * Created by xuanmao on 2020/11/4.
 */
public class leetcode1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long l = 1;
        long r = Integer.MAX_VALUE - 1;
        long ab = a * b / getGcd(a, b);
        long ac = a * c / getGcd(a, c);
        long bc = b * (c / getGcd(b, c));
        long abc = ab * (c / getGcd(ab, c));
        while (l < r) {
            long mid = (l + r) / 2;
            long count = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (count >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private long getGcd(long x, long y) {
        if (x < y) {
            return getGcd(y, x);
        }
        if (y == 0) {
            return x;
        }
        return getGcd(y, x % y);
    }
}
