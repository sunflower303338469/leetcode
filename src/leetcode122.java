/**
 * Created by xuanmao on 2019/4/11.
 */
public class leetcode122 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        boolean hasStock = false;
        int buyPrice = 0;
        for (int i=1;i<prices.length;i++){
            if (hasStock){
                if (prices[i]<prices[i-1]){
                    hasStock = false;
                    ans = ans + prices[i-1] - buyPrice;
                }
            } else {
                if (prices[i]>prices[i-1]){
                    hasStock = true;
                    buyPrice = prices[i-1];
                }
            }
        }
        if (hasStock){
            ans = ans + prices[prices.length-1] - buyPrice;
        }
        return ans;
    }
}
