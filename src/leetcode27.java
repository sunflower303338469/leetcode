/**
 * Created by xuanmao on 2019/8/14.
 */
public class leetcode27 {
    public int removeElement(int[] nums, int val) {
        int ans = nums.length;
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            while ((l<=r) && (nums[l] != val)){
                l++;
            }
            while ((l<=r) && (nums[r] == val)){
                ans--;
                r--;
            }
            if (l<r){
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                ans--;
                l++;
                r--;
            }
        }
        System.out.println(ans);
        return ans;
    }
}
