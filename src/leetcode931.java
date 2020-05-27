/**
 * Created by xuanmao on 2020/5/27.
 */
public class leetcode931 {
    public int minFallingPathSum(int[][] A) {
        if (A.length==0){
            return 0;
        }
        int[][] f= new int[A.length][A[0].length];
        for (int  i =0;i<A[0].length;i++){
            f[0][i] = A[0][i];
        }
        for (int i=1;i<A.length;i++){
            for (int j =0;j<A[0].length;j++){
                f[i][j] = f[i-1][j]+A[i][j];
                if (j!=0){
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1]+A[i][j]);
                }
                if (j!=A[0].length-1){
                    f[i][j] = Math.min(f[i][j], f[i-1][j+1]+A[i][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int  i=0;i<A[0].length;i++){
            ans = Math.min(ans,f[A.length-1][i]);
        }
        return ans;
    }
}
