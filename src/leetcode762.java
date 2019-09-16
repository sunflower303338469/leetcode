import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/8/16.
 */
public class leetcode762 {
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        int[] primeNumber = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        int count = 0;
        List<Integer> value = new ArrayList<>();
        int p = L;
        while (p > 0) {
            value.add(p % 2);
            count = count + p % 2;
            p = p / 2;
        }
        while (L <= R) {
            for (int i = 0; i < primeNumber.length; i++) {
                if (primeNumber[i] == count) {
                    ans++;
                }
            }
            int h = 0;
            value.set(0, value.get(0) + 1);
            while ((h < value.size()) && (value.get(h) > 1)) {
                value.set(h, 0);
                count--;
                h++;
                if (h < value.size()) {
                    value.set(h, value.get(h) + 1);
                }
            }
            if (h == value.size()) {
                value.add(1);
            }
            count++;
            L++;
        }
        return ans;
    }
}
