/**
 * Created by xuanmao on 2019/5/22.
 */
public class leetcode123 {
    /**
     * 0-第一次卖 1-第二次买 2-第二次卖
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int [][] f = new int[3][prices.length];
        for (int i=0;i<3;i++){
            for (int j=0;j<prices.length;j++){
                for (int k=0;k<j;k++){
                    if (i==0){
                        f[i][j] = Math.max(f[i][j], prices[j] - prices[k]);
                    } else if (i==1){
                        f[i][j] = Math.max(f[i][j], f[i-1][k]);
                    } else if (i==2){
                        f[i][j] = Math.max(f[i][j], f[i-1][k]+ prices[j]-prices[k]);
                    }
                    if (ans<f[i][j]){
                        ans = f[i][j];
                    }
                }
            }
        }
        return ans;
    }
}
