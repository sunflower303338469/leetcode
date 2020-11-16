/**
 * Created by xuanmao on 2020/9/14.
 */
public class leetcode565 {
    public int arrayNesting(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        int ans = 0;
        for (int i =0;i<nums.length;i++){
            if (!visit[i]){
                int num = 0;
                int p = i;
                while (!visit[p]){
                    num++;
                    visit[p] = true;
                    p = nums[p];
                }
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }
}
