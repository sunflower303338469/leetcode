/**
 * Created by xuanmao on 2019/10/6.
 */
public class leetcode5216 {
    int modNum = 1000000007;
    public int countVowelPermutation(int n) {
        long ans = 0;
        long[] f =  new long[5];
        long[] g =  new long[5];
        if (n==1){
            return 5;
        }
        f[0] = 1; //a
        f[1] = 1; //e
        f[2] = 1; //i
        f[3] =1; //o
        f[4] = 1; //u
        for (int i=2;i<=n;i++){
            g[0] = f[1] + f[2] + f[4];
            g[1] = f[0]+ f[2];
            g[2] = f[1] + f[3];
            g[3] = f[2];
            g[4] = f[2]+ f[3];
            ans = 0;
            for (int j=0;j<=4;j++){
                f[j] =g[j] % modNum;
                ans = (ans + f[j]) % modNum;
            }

        }
        return (int)ans;
    }
}
