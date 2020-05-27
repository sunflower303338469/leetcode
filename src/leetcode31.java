/**
 * Created by xuanmao on 2020/5/27.
 */
public class leetcode31 {
    public void nextPermutation(int[] nums) {
        int head = nums.length-1;
        while ((head!=0) && (nums[head]<=nums[head-1])){
            head--;
        }
        int f = head-1;
        int tail = nums.length-1;
        while (head<tail){
            int temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            head++;
            tail--;
        }
        if (f>=0){
            for (int i = f+1;i<nums.length;i++){
                if (nums[i]>nums[f]){
                    int temp = nums[f];
                    nums[f] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }
    }
}
