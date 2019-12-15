import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/10/6.
 */
public class leetcode5214 {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0;i<arr.length;i++){
            Integer before = map.get(arr[i]-difference);
            if (before != null){
                Integer now = map.get(arr[i]);
                if ((now == null ) || (now<before+1)){
                    map.put(arr[i], before+1);
                    if (before+1>ans){
                        ans = before+1;
                    }
                }
            } else {
                map.put(arr[i], 1);
            }
        }
        return ans;
    }
}
