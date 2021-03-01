/**
 * Created by xuanmao on 2021/1/10.
 */
public class leetcode1319 {
    int[] f;

    public int makeConnected(int n, int[][] connections) {
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        if (connections.length < n - 1) {
            return -1;
        }
        for (int i = 0; i < connections.length; i++) {
            int x = getFather(connections[i][0]);
            int y = getFather(connections[i][1]);
            f[x] = y;
        }
        int ans = 0;
        for (int i=0;i<n;i++){
            if (f[i] ==i){
                ans++;
            }
        }
        return ans-1;
    }

    private int getFather(int x) {
        while (f[x] != x) {
            f[x] = f[f[x]];
            x = f[x];
        }
        return x;
    }
}
