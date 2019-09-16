package notfinish;

/**
 * Created by xuanmao on 2019/6/2.
 */
public class leetcode1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] sum = new int[matrix.length][matrix[0].length];

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] nSum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                nSum[i][j] = matrix[i][j];
                if (j - 1 >= 0) {
                    nSum[i][j] += nSum[i][j - 1];
                }
                sum[i][j] = nSum[i][j];
                if (i - 1 >= 0) {
                    sum[i][j] += sum[i-1][j];
                }
            }
        }
        int ans =0;
        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int i2 = 0; i2 <= i1; i2++) {
                    for (int j2 = 0; j2 <= j1; j2++) {
                        int p = sum[i1][j1];
                        if (i1-i2-1 >=0){
                            p = p - sum[i1-i2-1][j1];
                        }
                        if (j1-j2-1>=0){
                            p = p - sum[i1][j1-j2-1];
                        }
                        if ((i1-i2-1 >=0) && (j1-j2-1>=0)){
                            p = p+sum[i1-i2-1][j1-j2-1];
                        }
                        if (p==target){
                            System.out.println(i1+ " "+j1+" "+i2+" "+j2);
                            ans ++;
                        }


                    }
                }
            }
        }
        return ans;
    }
}
