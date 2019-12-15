/**
 * Created by xuanmao on 2019/11/19.
 */
public class leetcode198 {
    public int rob(int[] nums) {
        int x = 0;  //上一个拿过的
        int y = 0;  //上一个没拿过的
        for (int i =0;i<nums.length;i++){
            int ty = Math.max(x, y);
            int tx = Math.max(x, y+nums[i]);
            y = ty;
            x = tx;
        }
        return Math.max(x,y);
    }
}
