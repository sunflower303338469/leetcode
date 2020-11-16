/**
 * Created by xuanmao on 2020/10/8.
 */
public class leetcode790 {
    public int numTilings(int N) {
        int mod = 1000000007;
        int[][] f = new int[4][N]; //0空，1上，2下，3满
        f[0][0] = 1;
        f[3][0] = 1;
        for (int i = 1; i < N; i++) {
            f[0][i] = f[3][i - 1];
            f[1][i] = (f[0][i - 1] + f[2][i - 1]) % mod;
            f[2][i] = (f[0][i - 1] + f[1][i - 1]) % mod;
            f[3][i] = (((f[0][i - 1] + f[1][i - 1]) % mod + f[2][i - 1]) % mod + f[3][i - 1]) % mod;
            System.out.println(f[0][i] + " " + f[1][i] + " " + f[2][i] + " " + f[3][i]);
        }
        return f[3][N - 1];
    }
}
