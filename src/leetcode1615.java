/**
 * Created by xuanmao on 2021/3/18.
 */
public class leetcode1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        int[] connect = new int[20000];
        for (int i = 0; i < roads.length; i++) {
            int x = roads[i][0];
            int y = roads[i][1];
            count[x]++;
            count[y]++;
            connect[x * n + y]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int value = count[i] + count[j] - connect[i * n + j] - connect[j * n + i];
                ans = Math.max(ans, value);
            }
        }
        return ans;
    }
}
