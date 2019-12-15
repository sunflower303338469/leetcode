/**
 * Created by xuanmao on 2019/10/7.
 */
public class leetcode221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length==0){
            return 0;
        }
        int[][] f = new int[matrix.length][matrix[0].length];
        for (int i =0;i<matrix.length;i++){
            for (int j =0;j<matrix[0].length;j++){
                if (matrix[i][j]=='1'){
                    if (j==0){
                        f[i][j] = 1;
                    } else {
                        f[i][j] = f[i][j-1]+1;
                    }
                }
            }
        }
        int ans = 0;
        for (int i =0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(f[i][j]>0){
                    int min = f[i][j];
                    for (int k=0;k<=i;k++){
                        min = Math.min(min, f[i-k][j]);
                        if (min>k){
                            ans = Math.max(ans, Math.min(k+1, min));
                        }
                    }
                }
            }
        }
        return ans*ans;
    }
}
