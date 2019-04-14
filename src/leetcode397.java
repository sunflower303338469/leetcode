/**
 * Created by xuanmao on 2019/3/1.
 */
public class leetcode397 {
    public int integerReplacement(int n) {
        int ans = 0;
        long ln = (long) n;
        while (ln > 1) {
            System.out.println(ln);
            if (ln % 2 == 0) {
                ans = ans + 1;
                ln = ln / 2;
            } else {
                ans = ans + 1;
                if (ln==3){
                    ans = ans +1;
                    ln = 1;
                    continue;
                }
                int p = get2(ln + 1);
                int q = get2(ln - 1);
                System.out.println(p + " " + q);
                if (p > q) {
                    ans = ans + p;
                    ln = ln + 1;
                    while (p > 0) {
                        ln = ln / 2;
                        p = p - 1;
                    }
                } else {
                    ans = ans + q;
                    ln = ln - 1;
                    while (q > 0) {
                        ln = ln / 2;
                        q = q - 1;
                    }
                }
            }
        }
        return ans;
    }

    private int get2(long n) {
        int count = 0;
        while (n % 2 == 0) {
            count = count + 1;
            n = n / 2;
        }
        return count;
    }
}
