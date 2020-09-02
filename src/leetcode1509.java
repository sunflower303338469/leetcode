import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/8/3.
 */
public class leetcode1509 {
    public int minDifference(int[] nums) {
        if (nums.length<=4){
            return 0;
        }
        List<Integer> valueList = new ArrayList<>();
        for (int i =0;i<nums.length;i++){
            valueList.add(nums[i]);
        }
        int ans = Integer.MAX_VALUE;
        valueList.sort(Comparator.naturalOrder());
        for (int i=0;i<=3;i++){
            ans = Math.min(ans, valueList.get(valueList.size()-4+i) - valueList.get(i));
        }
        return ans;
    }
}
