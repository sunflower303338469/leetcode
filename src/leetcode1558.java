/**
 * Created by xuanmao on 2021/4/27.
 */
public class leetcode1558 {

    class Deal {
        int mulNum = 0;
        int addNum = 0;
    }

    public int minOperations(int[] nums) {

        int ans = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            Deal deal = getDeal(nums[i]);
            ans = ans + deal.addNum;
            max = Math.max(max, deal.mulNum);
        }
        return ans + max;
    }

    private Deal getDeal(int x) {
        Deal deal = new Deal();
        while (x != 0) {
            if (x % 2 == 0) {
                x = x / 2;
                deal.mulNum++;
            } else {
                x = x - 1;
                deal.addNum++;
            }
        }
        return deal;
    }
}
