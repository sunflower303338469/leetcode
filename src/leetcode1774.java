import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2021/5/4.
 */
public class leetcode1774 {
    int[] tc;
    List<Integer> topList = new ArrayList<>();

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        tc = toppingCosts;
        dfs(0, 0);
        int abs = Integer.MAX_VALUE;
        int ans = 0;
        for (Integer x : topList) {
            for (int i = 0; i < baseCosts.length; i++) {
                int sum = x + baseCosts[i];
                if (abs == Math.abs(sum - target)) {
                    ans = Math.min(ans, sum);
                } else if (abs > Math.abs(sum - target)) {
                    ans = sum;
                    abs = Math.abs(sum-target);
                }
            }
        }
        return ans;
    }

    private void dfs(int index, int sum) {
        if (index>=tc.length){
            topList.add(sum);
            return;
        }
        for ( int i=0;i<3;i++){
            dfs(index+1, sum+tc[index]*i);
        }
    }
}
