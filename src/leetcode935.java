/**
 * Created by xuanmao on 2019/11/12.
 */
public class leetcode935 {
    public int knightDialer(int N) {
        int modValue = 1000000007;
        long[] f = new long[10];
        long[] g = new long[10];
        for (int i =0;i<10;i++){
            f[i] = 1;
            g[i] = 1;
        }
        for (int i=1; i<N;i++){
            f[0] = (g[4]+g[6]) % modValue;
            f[1] = (g[6]+g[8]) % modValue;
            f[2] = (g[7]+g[9]) % modValue;
            f[3] = (g[4]+g[8]) % modValue;
            f[4] = (g[3]+g[9]+g[0]) % modValue;
            f[5] = 0;
            f[6] = (g[1]+g[7]+g[0]) % modValue;
            f[7] = (g[2]+g[6]) % modValue;
            f[8] = (g[1]+g[3]) % modValue;
            f[9] = (g[2]+g[4]) % modValue;
            g[0] = f[0];
            g[1] = f[1];
            g[2] = f[2];
            g[3] = f[3];
            g[4] = f[4];
            g[5] = f[5];
            g[6] = f[6];
            g[7] = f[7];
            g[8] = f[8];
            g[9] = f[9];
        }
        long ans = 0;
        for (int i =0;i<10;i++){
            ans = (ans + f[i] )%modValue;
        }
        return (int)ans;
    }
}
