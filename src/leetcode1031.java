import java.util.regex.Pattern;

/**
 * Created by xuanmao on 2019/4/21.
 */
public class leetcode1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i=1;i<A.length;i++){
            sum[i] = A[i]+sum[i-1];
        }
        int[] sumL = new int[A.length];
        int ans=0;
        sumL[L-1] = sum[L-1];
        for (int i=L;i<A.length;i++){
            sumL[i] = sum[i] - sum[i-L];
        }
        int[] sumM = new int[A.length];
        sumM[M-1] = sum[M-1];
        for (int i=M;i<A.length;i++){
            sumM[i] = sum[i]-sum[i-M];
        }
        for (int i=M-1;i<A.length;i++){
            for (int j=L-1;j<A.length;j++){
                if ((i<j) && (j-i>=L)){
                    ans = max(ans, sumM[i]+sumL[j]);
                }
                if ((i>j) && (i-j>=M)){
                    ans = max(ans, sumM[i]+sumL[j]);
                }
            }
        }
        return ans;
    }
    private int max(int a,int b){
        if (a>b) {
            return a;
        }
        return b;
    }
}
