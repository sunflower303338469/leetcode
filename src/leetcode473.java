/**
 * Created by xuanmao on 2020/11/19.
 */
public class leetcode473 {

    boolean ans = false;
    boolean[] visit;
    int[] n;
    int row = 0;

    public boolean makesquare(int[] nums) {
        visit = new boolean[nums.length];
        n = nums;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        row = sum / 4;
        dfs(1, 0, 0);
        return ans;
    }

    private void dfs(int num, int count, int index) {
        if (num == 4) {
            ans = true;
        }
        if (ans) {
            return;
        }
        for (int i=index;i<visit.length;i++){
            if ((!visit[i]) && (count+n[i]<=row)){
                visit[i] = true;
                if (count+n[i] == row){
                    dfs(num+1,0,0);
                } else {
                    dfs(num, count+n[i], i+1);
                }
                visit[i] = false;
            }
        }
    }
}
