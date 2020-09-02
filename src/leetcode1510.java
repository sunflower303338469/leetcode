/**
 * Created by xuanmao on 2020/8/3.
 */
public class leetcode1510 {
    public boolean winnerSquareGame(int n) {
        boolean[] f = new boolean[n+1];
        for (int i=1;i<=n;i++){
            for (int j=1;j<=316;j++){
                if (j*j>i){
                    break;
                }
                f[i] = f[i] || (!f[i-j*j]);
            }
        }
        return f[n];
    }
}
