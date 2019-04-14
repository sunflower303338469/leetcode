/**
 * Created by xuanmao on 2019/2/27.
 */
public class leetcode909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int m = n * n;
        int[] a = new int[m + 1];
        int[] ans = new int[m + 1];
        int[] queue = new int[m + 1];
        boolean[] visited = new boolean[m + 1];
        int k = 1;
        int p = 0;
        boolean isPlus = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                a[k] = board[i][p];
                k = k + 1;
                if (isPlus) {
                    p = p + 1;
                } else {
                    p = p - 1;
                }
            }
            isPlus = !isPlus;
            if (isPlus) {
                p = p + 1;
            } else {
                p = p - 1;
            }
        }
        visited[1] = true;
        queue[0] = 1;
        ans[1] = 0;
        int l = 0;
        int r = 1;
        while (l < r) {
            System.out.println(queue[l] + " " + ans[queue[l]]);
            for (int i = 6; i >= 1; i--) {
                if (queue[l] + i <= m) {
                    int jumpPos = a[queue[l] + i];
                    if ((jumpPos <= m) && (jumpPos != -1)) {
                        if (visited[jumpPos]) {
                            continue;
                        }
                        visited[jumpPos] = true;
                        queue[r] = jumpPos;
                        ans[jumpPos] = ans[queue[l]] + 1;
                        System.out.println("  " + queue[r] + " " + ans[queue[r]]);
                        if (jumpPos == m) {
                            return ans[m];
                        }
                        r = r + 1;
                        continue;
                    }

                    if (!visited[queue[l] + i]) {
                        visited[queue[l] + i] = true;
                        queue[r] = queue[l] + i;
                        ans[queue[l] + i] = ans[queue[l]] + 1;
                        System.out.println("  " + queue[r] + " " + ans[queue[r]]);
                        if (queue[l] + i == m) {
                            return ans[m];
                        }
                        r = r + 1;
                    }

                }
            }
            l = l + 1;
        }
        return -1;
    }
}
