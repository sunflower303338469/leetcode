/**
 * Created by xuanmao on 2019/12/31.
 */
public class leetcode48 {
    public void rotate(int[][] matrix) {
        int[] tx = {0,0,matrix.length-1,matrix.length-1};
        int[] ty = {0,matrix[0].length-1,matrix[0].length-1,0};

        for (int i =0;i<matrix.length;i++){
            for (int j =0;j<matrix[0].length;j++){
                if ((i>=(matrix.length+1)/2) || (j>=matrix[0].length/2)){
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[tx[3]-j][ty[3]+i];
                matrix[tx[3]-j][ty[3]+i] = matrix[tx[2]-i][ty[2]-j];
                matrix[tx[2]-i][ty[2]-j] = matrix[tx[1]+j][ty[1]-i];
                matrix[tx[1]+j][ty[1]-i] = temp;
            }
        }
    }
}
