/**
 * Created by xuanmao on 2020/9/28.
 */
public class leetcode1578 {
    public int minCost(String s, int[] cost) {
        Character c = s.charAt(0);
        int sum = cost[0];
        int max = cost[0];
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                sum =  sum+cost[i];
                max = Math.max(max, cost[i]);
            } else {
                ans = ans + sum - max;
                sum  =cost[i];
                max = cost[i];
                c=  s.charAt(i);
            }
        }
        ans = ans + sum - max;
        return ans;
    }
}
