package notfinish;

/**
 * Created by xuanmao on 2019/7/28.
 */
public class leetcode1140 {
    public int stoneGameII(int[] piles) {
        int[] sum= new int[piles.length];
        int[][] f = new int[piles.length][piles.length+1];
        sum[0] = piles[0];
        for (int i =1;i<piles.length;i++){
            sum[i] = sum[i-1] + piles[i];
        }
        f[0][1] = sum[0];
        f[1][2] = sum[1];
        for (int i =1;i<=piles.length;i++){
            for (int j=0;j<piles.length;j++){
                for (int k=1;k<=i/2;k++){
                    for (int t=1;t<=i;t++){
                        f[i][j] = 0;



                    }
                }
            }
        }
        return 0;
    }
}
