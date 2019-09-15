/**
 * Created by xuanmao on 2019/4/23.
 */
public class leetcode805 {
    public boolean splitArraySameAverage(int[] A) {
        int n = 0;
        for (int i = 0; i < A.length; i++) {
            n = n + A[i];
        }
        boolean[][] flag = new boolean[A.length][n + 1];
        flag[0][0] = true;

        for (int i = 0; i < A.length; i++) {
            for (int k = A.length-1; k >=1; k--) {
                for (int j = n; j > 0; j--) {
                    if ((j >= A[i]) && (flag[k - 1][j - A[i]])) {
                        flag[k][j] = true;
                        if (j * A.length == k * n) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
