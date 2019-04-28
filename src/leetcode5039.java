/**
 * Created by xuanmao on 2019/4/28.
 */
public class leetcode5039 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] ans = new int[2];
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        if (b > c) {
            int t = b;
            b = c;
            c = t;
        }
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        System.out.println(a + " " + b + " " + c);
        ans[1] = c - a - 2;
        if ((b - a <= 2) || (c - b <= 2)) {
            if (b - a == 1 && c - b == 1) {
                ans[0] = 0;
            } else {
                ans[0] = 1;
            }
        } else {
            ans[0] = 2;
        }
        return ans;
    }
}
