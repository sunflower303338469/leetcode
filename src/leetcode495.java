/**
 * Created by xuanmao on 2020/9/28.
 */
public class leetcode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int finish = Integer.MIN_VALUE;
        for (int i=0;i<timeSeries.length;i++){
            if (timeSeries[i]>=finish){
                ans =ans +duration;
            } else {
                ans = ans + duration - (finish-timeSeries[i]);
            }
            finish = timeSeries[i]+duration;
        }
        return ans;
    }
}
