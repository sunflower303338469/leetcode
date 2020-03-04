/**
 * Created by xuanmao on 2020/1/16.
 */
public class leetcode309 {

    public int maxProfit(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int[][][] f = new int[prices.length][2][2];  //f[a][b][c] = a位置，b有没有股票，c是不是在cd
        f[0][1][0] = -prices[0];
        f[0][0][0] = 0;
        for (int i =1;i<prices.length;i++){
            f[i][1][0] = Math.max(f[i-1][1][0], f[i-1][0][0]-prices[i]);
            f[i][0][0] = Math.max(f[i-1][0][0], f[i-1][0][1]);
            f[i][0][1] = Math.max(f[i-1][1][0]+prices[i], f[i][0][0]);
        }
        return Math.max(Math.max(f[prices.length-1][1][0], f[prices.length-1][0][0]),f[prices.length-1][0][1]);
    }
}
