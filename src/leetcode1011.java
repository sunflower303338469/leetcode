/**
 * Created by xuanmao on 2020/10/6.
 */
public class leetcode1011 {
    public int shipWithinDays(int[] weights, int D) {
        int r = 30000000;
        int l = 0;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(mid, weights) > D) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int check(int capacity, int[] weights) {
        int now = 0;
        int days = 1;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity) {
                return Integer.MAX_VALUE;
            }
            if (now + weights[i] > capacity) {
                days++;
                now = weights[i];
            } else {
                now += weights[i];
            }
        }
        return days;
    }
}
