/**
 * Created by xuanmao on 2020/5/26.
 */
public class leetcode287 {
    public int findDuplicate(int[] nums) {
        int i=nums[0],j=nums[i];
        while (i!=j){
            i=nums[i];
            j=nums[nums[j]];
        }
        i=0;
        while (i!=j){
            i=nums[i];
            j=nums[j];
        }
        return i;
    }
}
