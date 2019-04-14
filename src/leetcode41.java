/**
 * Created by xuanmao on 2019/1/25.
 */
public class leetcode41 {
    public int firstMissingPositive(int[] nums) {
        for (int i =0;i<nums.length;i++){
            deal(i, nums);
        }
        for (int i =0;i<nums.length;i++){
            if (nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length + 1;
    }

    private void deal(int i, int[] nums){
        int n = nums.length;
        while ((nums[i] <= n) && (nums[i]>0) && (nums[i] != i+1)) {
            int temp = nums[i];
            if (nums[temp - 1] == temp){
                return;
            }
            nums[i] = nums[temp - 1];
            nums[temp - 1] = temp;
        }
    }
}
