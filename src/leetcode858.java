/**
 * Created by xuanmao on 2020/7/9.
 */
public class leetcode858 {
    public int mirrorReflection(int p, int q) {
        if (q == 0) {
            return 0;
        }
        if (q == p) {
            return 1;
        }
        boolean left = true;
        boolean up = true;
        int value = q;
        while (value != 0) {
            value = value + q;
            left = !left;
            if (value > p) {
                up = !up;
            }
            value = value % p;
        }
        if ((left) && (up)) {
            return 1;
        }
        if ((left) && (!up)) {
            return 0;
        }
        if ((!left) && (up)) {
            return 2;
        }
        return -1;
    }
}
