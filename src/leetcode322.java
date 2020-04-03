/**
 * Created by xuanmao on 2020/3/8.
 */
public class leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount+1];
        for (int i =1;i<=amount;i++){
            f[i] = Integer.MAX_VALUE;
            for (int j =0;j<coins.length;j++){
                if ((i>=coins[j]) && (f[i-coins[j]]!=Integer.MAX_VALUE)){
                    f[i] = Math.min(f[i], f[i-coins[j]]+1);
                }
            }
        }
        return f[amount] != Integer.MAX_VALUE?f[amount]:-1;
    }
}
