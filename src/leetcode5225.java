import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuanmao on 2019/10/13.
 */
public class leetcode5225 {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> valueMap = new LinkedHashMap<>();
        int ans = 0;
        for (int i =0;i<nums.length;i++){
            Integer num = map.getOrDefault(nums[i],0);
            map.put(nums[i], num+1);
            if (num != 0){
                Integer value = valueMap.get(num);
                if (value == 1) {
                    valueMap.remove(num);
                } else {
                    valueMap.put(num, value - 1);
                }
            }
            Integer newValue = valueMap.getOrDefault(num+1, 0);
            valueMap.put(num+1, newValue+1);
            Set<Integer> keys = valueMap.keySet();
            if (keys.size() == 2){
                if (valueMap.getOrDefault(1,0)==1){
                    ans  = i+1;
                }
                for (Integer v:keys){
                    if ((valueMap.get(v)== 1) && (valueMap.containsKey(v-1))){
                        ans = i+1;
                    }
                }
            }
            if ((keys.size() == 1) && (keys.contains(1))){
                ans = i+1;
            }
            if (map.keySet().size() == 1){
                ans = i+1;
            }
        }
        return ans;
    }
}
