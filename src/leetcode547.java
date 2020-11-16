/**
 * Created by xuanmao on 2020/10/20.
 */
public class leetcode547 {
    int[] f;

    public int findCircleNum(int[][] M) {
        f = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            f[i] = i;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if ((i != j) && (M[i][j] == 1)) {
                    int rootI = getRoot(i);
                    int rootJ = getRoot(j);
                    f[rootI] = rootJ;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i] == i) {
                ans++;
            }
        }
        return ans;
    }

    private int getRoot(int index) {
        while (f[index] != index) {
            f[index] = f[f[index]];
            index = f[index];
        }
        return index;
    }
}
