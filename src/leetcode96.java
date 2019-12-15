/**
 * Created by xuanmao on 2019/12/11.
 */
public class leetcode96 {
    public int numTrees(int n) {
        if (n==0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        for (int i=3;i<=n;i++){
            for (int j=0;j<i;j++){
                f[i] += f[j]*f[i-j-1];
            }
        }
        return f[n];
    }
}
