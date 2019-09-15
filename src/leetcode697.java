import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2019/5/16.
 */
public class leetcode697 {
    public int findShortestSubArray(int[] nums) {
        int maxNum = 0;
        int ans = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        Map<Integer, Integer> firstMap = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (numMap.containsKey(nums[i])){
                int p = numMap.get(nums[i]);
                p = p+1;
                numMap.put(nums[i], p);
                if (p>maxNum){
                    maxNum = p;
                    ans = i-firstMap.get(nums[i])+1;
                }
                if ((p==maxNum) && (ans>i-firstMap.get(nums[i])+1)){
                    ans = i-firstMap.get(nums[i])+1;
                }
            } else {
                numMap.put(nums[i], 1);
                firstMap.put(nums[i], i);
            }
        }
        return ans;
    }
}
