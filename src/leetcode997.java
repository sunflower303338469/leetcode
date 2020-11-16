/**
 * Created by xuanmao on 2020/11/3.
 */
public class leetcode997 {
    public int findJudge(int N, int[][] trust) {
        int ans = -1;
        int[] count = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
            count[trust[i][1]]++;
            count[trust[i][0]]--;

        }
        for (int i = 1; i <= N; i++) {
            if (count[i] == N - 1) {
                ans = i;
            }
        }

        return ans;
    }
}
