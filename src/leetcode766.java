/**
 * Created by xuanmao on 2021/2/22.
 */
public class leetcode766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int[] v = new int[matrix[0].length];
        for (int i =0;i<matrix[0].length;i++){
            v[i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = matrix[0].length - 1; j > 0; j--) {
                if (v[j - 1] != matrix[i][j]) {
                    return false;
                }
                v[j] = v[j-1];
            }
            v[0] =matrix[i][0];
        }
        return true;
    }
}
