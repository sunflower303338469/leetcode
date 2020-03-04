/**
 * Created by xuanmao on 2020/1/21.
 */
public class leetcode206 {
    public int[] singleNumber(int[] nums) {
        int xorValue =0;
        for (int i =0;i<nums.length;i++){
            xorValue = xorValue ^ nums[i];
        }
        // 两个不同值的第一位不同
        int lowbit  = xorValue & (-xorValue);
        int x = 0;
        for (int i =0;i<nums.length;i++){
            if ((nums[i] & lowbit)>0){
                x = x ^ nums[i];
            }
        }
        int[] ans = {x, xorValue ^ x};
        return ans;
    }
}
