/**
 * Created by xuanmao on 2020/4/5.
 */
public class leetcode153 {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length-1);

    }

    private int find(int[] nums, int l ,int r){
        if (l==r){
            return nums[l];
        }
        if (l==r-1){
            return Math.min(nums[l],nums[r]);
        }
        int mid = (l+r)/2;
        if (nums[mid]<nums[l]){
            return find(nums, l+1, mid);
        }
        if (nums[r]<nums[mid]){
            return find(nums, mid+1, r);
        }
        return nums[l];
    }
}
