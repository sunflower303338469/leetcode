import java.util.HashSet;

/**
 * Created by xuanmao on 2020/6/11.
 */
public class leetcode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        k = Math.min(nums.length-1,k);
        HashSet<Integer> set = new HashSet();
        for (int i =0;i<=k;i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        for (int i=k+1;i<nums.length;i++){
            set.remove(nums[i-k-1]);
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
