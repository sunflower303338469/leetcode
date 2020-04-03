/**
 * Created by xuanmao on 2020/3/9.
 */
public class leetcode121 {
    public int maxProfit(int[] prices) {
        int ans  =0;
        int min = Integer.MAX_VALUE;
        for (int i =0;i<prices.length;i++){
            if (ans < prices[i]-min){
                ans = prices[i]-min;
            }
            if (prices[i]<min){
                min = prices[i];
            }
        }

        return ans;
    }
}
