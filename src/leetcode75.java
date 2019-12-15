/**
 * Created by xuanmao on 2019/12/11.
 */
public class leetcode75 {

    public void sortColors(int[] nums) {
        int v0 = 0;
        int v1 = nums.length-1;
        int i = 0;
        while (i<=v1){
            if (nums[i] ==0 ){
                nums[i] = nums[v0];
                nums[v0] = 0;
                v0++;
                i++;
            } else if (nums[i] == 2){
                nums[i] = nums[v1];
                nums[v1] = 2;
                v1--;
            } else {
                i++;
            }
        }

    }
}
