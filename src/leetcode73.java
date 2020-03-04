/**
 * Created by xuanmao on 2020/1/22.
 */
public class leetcode73 {
    public void setZeroes(int[][] matrix) {
        int FLAG = Integer.MAX_VALUE/2;
        if (matrix.length==0){
            return;
        }
        for (int i =0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    for (int k = 0;k<matrix.length;k++){
                        if (matrix[k][j]!=0){
                            matrix[k][j] = FLAG;
                        }
                    }
                    for (int k=0;k<matrix[0].length;k++){
                        if (matrix[i][k]!=0){
                            matrix[i][k] = FLAG;
                        }
                    }
                }
            }
        }
        for (int i =0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == FLAG) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
