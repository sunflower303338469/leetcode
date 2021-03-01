/**
 * Created by xuanmao on 2020/12/1.
 */
public class leetcode34 {
    int[] nums;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if (nums.length == 0) {
            return ans;
        }
        int l = 0;
        int r = nums.length - 1;
        ans[0] = getLeft(l, r, target);
        ans[1] = getRight(l, r, target);
        return ans;
    }

    private int getLeft(int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }

    private int getRight(int l, int r, int target) {
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
