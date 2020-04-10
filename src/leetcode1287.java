import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/4/6.
 */
public class leetcode1287 {
    public int findSpecialInteger(int[] arr) {
        Map<Integer,Integer> map =new HashMap<>();
        for (int i=0;i<arr.length;i++){
            int count = map.getOrDefault(arr[i],0)+1;
            if (count>arr.length/4){
                return arr[i];
            }
            map.put(arr[i], count);
        }
        return 0;
    }
}
