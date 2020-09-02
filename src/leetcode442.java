import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/5/27.
 */
public class leetcode442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int k = 0;
        while (k<nums.length){
            if (nums[k] ==k+1){
                k++;
            } else {
                int index = nums[k]-1;
                if (nums[index] == nums[k]){
                    ans.add(nums[k]);
                    k++;
                } else {
                    int temp = nums[index];
                    nums[index] = nums[k];
                    nums[k] = temp;
                    if (index<k){
                        k++;
                    }
                }
            }
        }
        return ans;
    }
}
