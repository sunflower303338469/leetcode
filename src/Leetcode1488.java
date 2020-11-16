import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by xuanmao on 2020/9/14.
 */
public class Leetcode1488 {

    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                if (map.containsKey(rains[i])) {
                    Integer x = treeSet.higher(map.get(rains[i]));
                    if (x == null) {
                        return new int[0];
                    }
                    ans[x] = rains[i];
                    treeSet.remove(x);
                }
                ans[i] = -1;
                map.put(rains[i], i);
            } else {
                treeSet.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}
