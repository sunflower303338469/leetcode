import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by xuanmao on 2020/9/11.
 */
public class leetcode380 {
    class RandomizedSet {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> valueList = new ArrayList<>();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)){
                return false;
            }
            valueList.add(val);
            map.put(val, valueList.size()-1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)){
                return false;
            }
            Integer index = map.get(val);
            map.remove(val);
            if (index!=valueList.size()-1){
                Integer lastValue=  valueList.get(valueList.size()-1);
                valueList.set(index, lastValue);
                map.put(lastValue, index);
            }
            valueList.remove(valueList.size()-1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            Random random = new Random();
            return valueList.get(random.nextInt(valueList.size()));
        }
    }
}
