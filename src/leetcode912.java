/**
 * Created by xuanmao on 2020/3/31.
 */
public class leetcode912 {

    private void qsort(int l, int r, int[] nums) {
        if (l >= r) {
            return;
        }
        int key = nums[l];
        int i = l;
        int j = r;
        while (i < j) {
            while ((i<j) && (key<=nums[j])){
                j--;
            }
            nums[i] = nums[j];
            while((i<j) && (nums[i]<=key)){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] =key;
        qsort(l, i-1, nums);
        qsort(i+1,r,nums);
    }

    public int[] sortArray(int[] nums) {
        qsort(0, nums.length - 1, nums);
        return nums;
    }
}
