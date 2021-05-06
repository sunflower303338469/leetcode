import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2021/4/27.
 */
public class leetcode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = 0;
        for (int i = 0;i<candies.length;i++){
            max = Math.max(max, candies[i]);
        }
        for (int i =0;i<candies.length;i++){
            ans.add(max<=candies[i]+extraCandies);
        }
        return ans;
    }
}
