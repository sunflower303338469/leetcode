import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xuanmao on 2020/8/27.
 */
public class leetcode981 {
    class TimeMap {

        Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> valueMap = map.getOrDefault(key, new TreeMap<>());
            valueMap.put(timestamp, value);
            map.put(key, valueMap);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> valueMap = map.getOrDefault(key, new TreeMap<>());
            Map.Entry<Integer, String> entry = valueMap.floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }
}
