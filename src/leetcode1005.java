/**
 * Created by xuanmao on 2019/10/14.
 */
public class leetcode1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        int[] f = new int[300];
        for (int i =0;i<A.length;i++){
            f[A[i]+100] ++;
        }
        int ans = 0;
        for (int i=0;i<300;i++){
            if (f[i] != 0) {
                if ((K>0)&& (i-100<0)){
                    if (K>=f[i]){
                        ans = ans - f[i] * (i-100);
                        K = K -f[i];
                    } else {
                        ans = ans - K * (i-100);
                        ans = ans + (f[i]-K) * (i-100);
                        K = 0;
                    }
                } else {
                    ans = ans + f[i] * (i-100);
                }
            }
        }
        int p = 9999;
        if ((K>0) && (K%2==1)){
            for (int i=0;i<300;i++){
                if (f[i]!=0){
                    int value = i-100;
                    p = Math.min(Math.abs(value), p);
                }
            }
            System.out.print(p);
            ans -=p*2;
        }
        return ans;
    }
}
