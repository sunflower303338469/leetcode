import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/4/14.
 */
public class leetcode910 {
    public int smallestRangeII(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }
        list.sort(Comparator.naturalOrder());
        int ans = list.get(list.size() - 1) - list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            int x = list.get(i)+K;
            int y = list.get(i+1)-K;
            int max = Math.max(x, list.get(list.size()-1)-K);
            int min = Math.min(y, list.get(0)+K);
            ans = Math.min(ans, max-min);
        }
        return ans;
    }
}
