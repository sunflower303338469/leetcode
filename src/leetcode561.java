import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2019/10/7.
 */
public class leetcode561 {
    public int arrayPairSum(int[] nums) {
        List<Integer> values = new ArrayList<>();
        for (int i =0;i<nums.length;i++){
            values.add(nums[i]);
        }
        values.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        int ans = 0;
        for (int i =0;i<values.size();i++){
            if (i%2==0){
                ans+=values.get(i);
            }
        }
        return ans;
    }
}
