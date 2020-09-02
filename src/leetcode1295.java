/**
 * Created by xuanmao on 2020/6/2.
 */
public class leetcode1295 {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int i=0;i<nums.length;i++){
            int k =0;
            do{
                k++;
                nums[i] = nums[i]/10;
            } while (nums[i]!=0);
            if (k % 2==0){
                ans++;
            }
        }
        return ans;
    }
}
