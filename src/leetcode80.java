/**
 * Created by xuanmao on 2020/4/12.
 */
public class leetcode80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int now = nums[0];
        int count  =1;
        int index = 1;
        for (int i=1;i<nums.length;i++){
            if (now == nums[i]){
                count++;
                if (count==2){
                    nums[index] = nums[i];
                    index++;
                }
            } else {
                now = nums[i];
                count = 1;
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
