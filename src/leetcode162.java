/**
 * Created by xuanmao on 2020/1/21.
 */
public class leetcode162 {
    public int findPeakElement(int[] nums) {
        int l =0;
        int r = nums.length-1;
        while (l<r){
            int mid = (l+r)/2;
            if (nums[mid]<nums[mid+1]){
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}