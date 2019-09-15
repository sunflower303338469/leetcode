/**
 * Created by xuanmao on 2019/5/23.
 */
public class leetcode810 {
    public boolean xorGame(int[] nums) {
        int flag= 0;
        for(int i=0;i<nums.length;i++){
            flag = flag ^ nums[i];
        }
        if ((flag == 0) || (nums.length% 2 ==0)){
            return true;
        }
        return false;
    }
}
