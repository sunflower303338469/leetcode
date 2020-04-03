import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuanmao on 2020/3/29.
 */
public class leetcode983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] f = new int[366];
        Set<Integer> needCover = new HashSet<>();
        for (int i = 0; i < days.length; i++) {
            needCover.add(days[i]);
        }
        for (int i = 1; i <= 365; i++) {
            if (needCover.contains(i)) {
                f[i] = f[i - 1] + costs[0];
                f[i] = Math.min(f[i], f[Math.max(0, i - 7)] + costs[1]);
                f[i] = Math.min(f[i], f[Math.max(0, i - 30)] + costs[2]);
            } else {
                f[i] = f[i - 1];
            }
        }
        return f[365];
    }
}
