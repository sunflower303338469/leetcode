import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/10/15.
 */
public class leetcode525 {

    public int findMaxLength(int[] nums) {
        int cha = 0;
        int ans = 0;
        Map<Integer, Integer> chaMap = new HashMap<>();
        for (int i =0;i<nums.length;i++){
            if (nums[i]==0){
                cha--;
            } else {
                cha++;
            }
            if (cha == 0){
                ans = i+1;
            }
            if (!chaMap.containsKey(cha)){
                chaMap.put(cha, i);
            } else {
                ans = Math.max(ans, i-chaMap.get(cha));
            }
        }
        return ans;
    }
}
