import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuanmao on 2020/4/30.
 */
public class leetcode202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while ((n != 1) && (!set.contains(n))) {
            set.add(n);
            int next = 0;
            while (n > 0) {
                int k = n % 10;
                next = next + k * k;
                n = n / 10;
            }
            n = next;
        }
        return n == 1;
    }
}
