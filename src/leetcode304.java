/**
 * Created by xuanmao on 2019/1/27.
 */
public class leetcode304 {
    public class NumMatrix {

        private int[][] maxtrixSum;
        private int n, m;

        public NumMatrix(int[][] matrix) {
            n = matrix.length;
            if (n==0){
                return;
            }
            m = matrix[0].length;
            maxtrixSum = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maxtrixSum[i][j] = matrix[i][j];
                    if (i-1>=0){
                        maxtrixSum[i][j] += maxtrixSum[i-1][j];
                    }
                    if (j-1>=0){
                        maxtrixSum[i][j] += maxtrixSum[i][j-1];
                    }
                    if ((i-1>=0) && (j-1>=0)){
                        maxtrixSum[i][j] -= maxtrixSum[i-1][j-1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = maxtrixSum[row2][col2];
            if (row1>0){
                ans -= maxtrixSum[row1-1][col2];
            }
            if (col1>0){
                ans -= maxtrixSum[row2][col1-1];
            }
            if ((row1>0) && (col1>0)){
                ans += maxtrixSum[row1-1][col1-1];
            }
            return ans;
        }
    }
}
