import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/10/15.
 */
public class leetcode1124 {
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int count = 0;
        int ans  =0;
        for (int i =0;i<hours.length;i++){
            if (hours[i]>8){
                count++;
            } else {
                count--;
            }
            if (count>0){
                ans = i+1;
            } else {
                if (countMap.containsKey(count-1)){
                    ans = Math.max(ans, i-countMap.get(count-1));
                }
                if (!countMap.containsKey(count)){
                    countMap.put(count, i);
                }
            }
        }
        return ans;
    }
}
