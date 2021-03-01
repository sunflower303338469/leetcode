/**
 * Created by xuanmao on 2020/11/17.
 */
public class leetcode59 {
    int[] tx = {0, 1, 0, -1};
    int[] ty = {1, 0, -1, 0};
    int[] next = {1, 2, 3, 0};

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int x = 0;
        int y = 0;
        int now = 0;
        for (int i = 1; i <= n * n; i++) {
            ans[x][y] = i;
            int nx = x + tx[now];
            int ny = y + ty[now];
            for (int k = 0; k < 4; k++) {
                if (!(nx >= n || ny >= n || nx < 0 || ny < 0 || ans[nx][ny] != 0)) {
                    break;
                }
                now = next[now];
                nx = x + tx[now];
                ny = y + ty[now];
            }

            x = nx;
            y = ny;
        }
        return ans;
    }
}
