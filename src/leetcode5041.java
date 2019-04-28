/**
 * Created by xuanmao on 2019/4/28.
 */
public class leetcode5041 {
    public int maxUncrossedLines(int[] A, int[] B) {
        int [][] f= new int[A.length][B.length];
        for (int i=0;i<A.length;i++){
            for (int j=0;j<B.length;j++){
                if (A[i] == B[j]){
                    if ((i>0) && (j>0)){
                        f[i][j] = f[i-1][j-1]+1;
                    } else {
                        f[i][j] = 1;
                    }
                }
                if ((i>0) && (f[i-1][j] >f[i][j])){
                    f[i][j] = f[i-1][j];
                }
                if ((j>0) && (f[i][j-1] >f[i][j])){
                    f[i][j] = f[i][j-1];
                }

            }
        }
        return f[A.length-1][B.length-1];
    }
}
