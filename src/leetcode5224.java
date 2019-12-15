/**
 * Created by xuanmao on 2019/10/13.
 */
public class leetcode5224 {
    public int dieSimulator(int n, int[] rollMax) {
        int mod = 1000000007;
        long [][][] f= new long[5000][6][16];
        long [] g = new long[6];
        for (int j=0;j<6;j++){
            f[0][j][1] = 1;
            g[j] = 1;
        }
        long now = 6;
        for (int i =1;i<n;i++){
            for (int j=0;j<6;j++){
                for (int k=1;k<=15;k++){
                    if (k == 1){
                        f[i][j][k] = (now - g[j] + mod) % mod;
                    } else if (k<=rollMax[j]){
                        f[i][j][k] = f[i-1][j][k-1];
                    }
                }
            }
            now = 0;
            for (int j=0;j<6;j++) {
                g[j] = 0;
                for (int k = 1; k <= 15; k++) {
                    now = (now+ f[i][j][k] )% mod ;
                    g[j] = (g[j] + f[i][j][k]) % mod;
                }
            }
        }
        return (int)now;
    }
}
