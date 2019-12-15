import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/11/19.
 */
public class leetcode677 {

    class MapSum {

        Map<String, Integer> strMap = new HashMap<>();
        /** Initialize your data structure here. */
        public MapSum() {

        }

        public void insert(String key, int val) {
            strMap.put(key, val);
        }

        public int sum(String prefix) {
            int ans = 0;
            for (String s:strMap.keySet()){
                if (s.startsWith(prefix)){
                    ans= ans + strMap.get(s);
                }
            }
            return ans;
        }
    }
}
