/**
 * Created by xuanmao on 2019/6/12.
 */
public class leetcode887 {
    public int superEggDrop(int K, int N) {
        int[][] f = new int[N+1][K+1]; //f[i,j] 尝试了i次，用了j个蛋
        int i=0;
        while ((i<N) && (f[i][K]<N)){
            i++;
            for (int j=1;j<=K;j++){
                f[i][j] =f[i-1][j-1]+ f[i-1][j] + 1;
            }
        }
        return i;
    }
}
