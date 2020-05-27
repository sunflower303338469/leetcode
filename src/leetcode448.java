import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/5/7.
 */
public class leetcode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i+1){
                int k = nums[i];
                if (nums[k-1] != k){
                    nums[i] = nums[k-1];
                    nums[k-1] = k;
                    i--;
                }
            }
        }
        for (int i =0;i<nums.length;i++){
            if (nums[i]!=i+1){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
