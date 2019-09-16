/**
 * Created by xuanmao on 2019/8/4.
 */
public class leetcode1144 {
    public int movesToMakeZigzag(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = 0;
            if (i > 0) {
                t = Math.max(t, nums[i]-nums[i-1]+1);
            }
            if (i < nums.length - 1) {
                t = Math.max(t, nums[i]-nums[i+1]+1);
            }
            if (i%2==0){
                a = a+t;
            } else {
                b = b+t;
            }
        }
        return Math.min(a,b);
    }
}
