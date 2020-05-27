import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/5/27.
 */
public class leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i  =0; i<numbers.length;i++){
            Integer index = map.get(target-numbers[i]);
            if (index!=null){
                int[] ans = new int[2];
                ans[0] = index+1;
                ans[1] = i+1;
                return ans;
            }
            map.put(numbers[i], i);
        }
        return new int[2];
    }
}
