import static java.lang.Math.max;

/**
 * Created by xuanmao on 2019/5/12.
 */
public class leetcode5057 {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int [][] max = new int[A.length][A.length];
        int[] f = new int[A.length];
        for (int i=0;i<A.length;i++){
            for (int j=i;j<A.length;j++){
                if (j==i){
                    max[i][j] = A[i];
                } else {
                    max[i][j] = Math.max(A[j],max[i][j-1]);
                }
            }
        }
        for (int i=0;i<A.length;i++){
            for (int j=1;j<=K;j++){
                if (i-j>=0){
                    f[i] = Math.max(f[i], f[i-j]+max[i-j+1][i]*j);
                } else if (i-j==-1){
                    f[i] = Math.max(f[i], max[i-j+1][i]*j);
                }
            }
            System.out.println(f[i]);
        }
        return f[A.length-1];
    }
}
