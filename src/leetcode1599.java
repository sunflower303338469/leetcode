/**
 * Created by xuanmao on 2021/3/17.
 */
public class leetcode1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int nowPeople = 0;
        int ans = 0;
        int maxMoney = 0;
        int nowMoney = 0;
        for (int i = 0; i < customers.length; i++) {
            nowPeople += customers[i];
            int onPeople = nowPeople > 4 ? 4 : nowPeople;
            nowMoney = nowMoney + onPeople * boardingCost;
            nowMoney -= runningCost;
            nowPeople -= onPeople;
            if (nowMoney > maxMoney) {
                maxMoney = nowMoney;
                ans = i + 1;
            }
        }
        int round = customers.length;
        while (nowPeople > 0) {
            round++;
            int onPeople = nowPeople > 4 ? 4 : nowPeople;
            nowMoney = nowMoney + onPeople * boardingCost;
            nowMoney -= runningCost;
            nowPeople -= onPeople;
            if (nowMoney > maxMoney) {
                maxMoney = nowMoney;
                ans = round;
            }
        }
        return ans == 0 ? -1 : ans;
    }
}
