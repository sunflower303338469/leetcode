import java.util.regex.Pattern;

/**
 * Created by xuanmao on 2019/5/23.
 */
public class leetcode861 {
    public int matrixScore(int[][] A) {
        int n = A.length;
        int m =A[0].length;
        for (int i =0;i<n;i++){
            if (A[i][0] == 0){
                for (int j=0;j<m;j++){
                    A[i][j] = 1-A[i][j];
                }
            }
        }
        for (int j=1;j<m;j++){
            int count = 0;
            for (int i=0;i<n;i++){
                if (A[i][j] ==0){
                    count ++;
                }
            }
            if (count>n/2){
                for (int i=0;i<n;i++){
                    A[i][j] = 1-A[i][j];
                }
            }
        }
        int ans =0;
        for (int i=0;i<n;i++){
            int value = 1;
            for (int j=m-1;j>=0;j--){
                ans = ans + A[i][j] * value;
                value = value*2;
            }
        }
        return ans;
    }
}
