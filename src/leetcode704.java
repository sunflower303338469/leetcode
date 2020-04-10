/**
 * Created by xuanmao on 2020/4/5.
 */
public class leetcode704 {
    public int search(int[] nums, int target) {
        return find(nums, 0, nums.length-1, target);
    }

    private int find(int[] nums, int l, int r, int target){
        if (l==r){
            if (nums[l]!=target){
                return -1;
            }
            return l;
        }
        int mid = (l+r)/2;
        if (nums[mid]<target){
            return find(nums, mid+1, r, target);
        } else if (nums[mid]>target){
            return find(nums, l, mid-1, target);
        } else {
            return mid;
        }
    }
}
