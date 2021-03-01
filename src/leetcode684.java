/**
 * Created by xuanmao on 2021/1/13.
 */
public class leetcode684 {

    int[] f;

    public int[] findRedundantConnection(int[][] edges) {
        f = new int[edges.length + 1];
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int f1 = getFather(edges[i][0]);
            int f2 = getFather(edges[i][1]);
            if (f1 == f2) {
                int[] ans = new int[2];
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
                return ans;
            }
            f[f1] = f2;
        }
        return new int[0];
    }

    private int getFather(int index) {
        while (index != f[index]) {
            f[index] = f[f[index]];
            index = f[index];
        }
        return index;
    }
}
