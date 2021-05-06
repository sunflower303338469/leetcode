/**
 * Created by xuanmao on 2021/3/23.
 */
public class leetcode1718 {
    int[] ans;
    boolean[] visit;
    int nn;

    public int[] constructDistancedSequence(int n) {
        ans = new int[n * 2 - 1];
        nn = n;
        visit = new boolean[n + 1];
        dfs(0);

        return ans;
    }

    private boolean dfs(int index) {
        if (index >= ans.length) {
            return true;
        }
        if (ans[index] != 0) {
            return dfs(index + 1);
        }
        for (int i = nn; i >= 1; i--) {
            if (!visit[i]) {
                if (i == 1) {
                    visit[i] = true;
                    ans[index] = i;
                    if (dfs(index + 1)){
                        return true;
                    }
                    ans[index] = 0;
                    visit[i] = false;
                } else if ((index + i < ans.length) && (ans[index+i]==0)) {
                    visit[i] = true;
                    ans[index] = i;
                    ans[index+i] = i;
                    if (dfs(index+1)){
                        return true;
                    }
                    visit[i] = false;
                    ans[index] = 0;
                    ans[index+i] = 0;
                }
            }
        }
        return false;
    }
}
