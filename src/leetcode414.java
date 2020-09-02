/**
 * Created by xuanmao on 2020/6/15.
 */
public class leetcode414 {
    public int thirdMax(int[] nums) {
        Integer[] ans = new Integer[3];
        for (int i = 0; i < 3; i++) {
            ans[i] = null;
        }
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            for (int j = 0; j < 3; j++) {
                if (ans[j]==null){
                    ans[j] = k;
                    break;
                }
                if (k > ans[j]) {
                    int temp = k;
                    k = ans[j];
                    ans[j] = temp;
                } else if (k == ans[j]) {
                    break;
                }
            }
        }
        return ans[2] == null ? ans[0] : ans[2];
    }
}
