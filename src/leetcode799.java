/**
 * Created by xuanmao on 2019/2/25.
 */
public class leetcode799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] a = new double[query_row+1][query_row+1];
        a[0][0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                a[i][j] = 0;
                if (a[i-1][j]-1 > 0){
                    a[i][j] += (a[i-1][j]-1)/2;
                }
                if ((j != 0) && (a[i-1][j-1]-1>0)){
                    a[i][j] += (a[i - 1][j - 1]-1)/2;
                }
            }
        }
        if (a[query_row][query_glass] > 1){
            return 1;
        }
        return a[query_row][query_glass];
    }
}
