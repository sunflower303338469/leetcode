/**
 * Created by xuanmao on 2020/4/14.
 */
public class leetcode1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[nums.length];
        for (int i=0;i<ans.length;i++){
            ans[i]=-1;
        }
        for (int i=0;i<index.length;i++){
            if (ans[index[i]] == -1){
                ans[index[i]] = nums[i];
            } else {
                int p = index[i];
                while (ans[p]!=-1){
                    p++;
                }
                for (int j = p;j>index[i];j--){
                    ans[j] = ans[j-1];
                }
                ans[index[i]] = nums[i];
            }
        }
        return ans;
    }
}
