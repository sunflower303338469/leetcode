import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/8/3.
 */
public class leetcode1508 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1000000007;
        List<Integer> valueList = new ArrayList<>();
        for (int i =0;i<nums.length;i++){
            int value = 0;
            for (int j =i;j<nums.length;j++){
                value = value + nums[j];
                valueList.add(value);
            }
        }
        valueList.sort(Comparator.naturalOrder());
        int ans  =0;
        for (int i = left-1;i<=right-1;i++){
            ans  = (ans +valueList.get(i)) % mod;
        }
        return ans;
    }
}
