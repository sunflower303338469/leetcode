/**
 * Created by xuanmao on 2020/2/19.
 */
public class leetcode714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length<=1){
            return 0;
        }
        int[][] f = new int[prices.length][2];
        f[0][1] = -prices[0];
        for (int i=1;i<prices.length;i++){
            f[i][0] = Math.max(f[i-1][0], f[i-1][1]+prices[i]-fee);
            f[i][1] = Math.max(f[i-1][1], f[i-1][0]-prices[i]);
            System.out.println(f[i][0]+" "+f[i][1]);
        }
        return f[prices.length-1][0];
    }
}
